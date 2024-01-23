package co.edu.uniquindio.proyecto_isw3.seguridad;

import co.edu.uniquindio.proyecto_isw3.modelo.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@PropertySource("classpath:application.properties")
public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET = "UDpyMqhp23kVNvviuKbBZSNHu53JmTXaM1dBSUAbDm4beCeHj19LUpdXqfNHuKpKZAYY45ivTN6T5KRm77jNLKAwfhnbKcrTZ3PrkrJ1kdRw7Gw3VJq3EgpSVqyXUGvYqPhejJYiVyjJDZp1t9SjzTKJWgfPAVzHLu12ABQ5GDnxatv1JF2dbnSZF7TQ2RRaXXE4TL4MVNc6Q83k4X67y2y3KTg4qh1AWBQ2L2zAm4uefVfwvnBf4QHh2pQKyeDG";

    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 7200000L;

    private static MessageSource ms;

    /**
     *
     * @param usuario
     * @return String token
     */
    public static String getJWTToken(Usuario usuario) throws Exception {
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(usuario.getRol().toString());

        String token = Jwts
                .builder()
                .claim("userId", usuario.getDocumento())
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS))
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();

        return "Bearer " + token;
    }

    public static Claims decodeToken(String token) {
        return Jwts.parserBuilder().setSigningKey(ACCESS_TOKEN_SECRET.getBytes()).build().parseClaimsJws(token).getBody();
    }
}
