package com.example.oauth2.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author yangyong
 */

@Slf4j
@Component
@Order(value = Integer.MIN_VALUE)
public class JsonToUrlEncodedAuthenticationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {

        log.debug("request.getContentType : {} ", request.getContentType());
        log.debug("request ServletPath : {}", request.getServletPath());

        if (Objects.equals(request.getContentType(), "application/json")
                && Objects.equals(request.getServletPath(), "/oauth/token")) {
            InputStream is = request.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            int nRead;
            byte[] data = new byte[16384];

            while ((nRead = is.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            byte[] json = buffer.toByteArray();

            HashMap<String, String> result = new ObjectMapper().readValue(json, HashMap.class);
            HashMap<String, String[]> r = new HashMap<>();
            for (String key : result.keySet()) {
                String[] val = new String[1];
                val[0] = result.get(key);
                r.put(key, val);
            }

            String[] val = new String[1];
            val[0] = request.getMethod();
            r.put("_method", val);

            HttpServletRequest s = new MyServletRequestWrapper(request, r);
            chain.doFilter(s, response);
        } else {
            chain.doFilter(request, response);
        }

    }
}
