package com.woyo.toko.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woyo.toko.dto.AuthResponse;
import com.woyo.toko.dto.request.UserRequestLoginDTO;
import com.woyo.toko.model.UserModel;
import com.woyo.toko.repository.UserRepository;
import com.woyo.toko.response.DataResponse;
import com.woyo.toko.response.HandlerResponse;
import com.woyo.toko.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository userRepository;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, ApplicationContext ctx) {
        this.authenticationManager = authenticationManager;
        this.userRepository = ctx.getBean(UserRepository.class);
        setFilterProcessesUrl("/api/v1/user/auth/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserRequestLoginDTO userRequestLoginDTO = new ObjectMapper()
                    .readValue(request.getInputStream(), UserRequestLoginDTO.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userRequestLoginDTO.getEmail(), userRequestLoginDTO.getPassword(), new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String[] username =((User) authResult.getPrincipal()).getUsername().split("-");

        try {
            Optional<UserModel> user = userRepository.findById(Integer.parseInt(username[0]));
            successAuthenticationResponse(response, username, user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            HandlerResponse.responseInternalServerError(response, e.getMessage());
        }
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        HandlerResponse.responseBadRequest(response, 400, "Email or password is wrong");
    }

    private void successAuthenticationResponse(HttpServletResponse response, String[] username, Optional<UserModel> userModel) {
        String token = TokenUtils.generateToken(username[0]);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setUserId(userModel.get().getUserId());
        authResponse.setFirstName(userModel.get().getFirstName());
        authResponse.setLastName(userModel.get().getLastName());
        authResponse.setEmail(userModel.get().getEmail());
        authResponse.setToken(token);

        DataResponse<AuthResponse> data = new DataResponse<>();
        data.setData(authResponse);
        HandlerResponse.responseSuccessWithData(response, data);
    }
}
