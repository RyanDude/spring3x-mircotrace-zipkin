package org.cloud.sample.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;

public class JwtTool {
//    @Value("${jwt.token.key}")
    private final String secret = "C*F-JaNdRgUkXn2r5u8x/A?D(G+KbPeShVmYq3s6v9y$sB&E)H@McQfTjWnZr4u7w";
//    @Value("${jwt.token.duration}")
    private final long EXPIRE_DURATION = 3600;
//    @Value("${jwt.token.role_claim}")
    private final String role_claim = "rol";

    public String getUsername(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    public String getRole(String token){
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return claims.get(role_claim).toString();
    }
    public String generateAccessToken(JwtUser user) {
        List<String> roles=user.getAuthorities();
        return   Jwts.builder()
                .setSubject(user.getUsername())
                .claim(role_claim, String.join(",", roles))
                .setIssuer("J.G")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

}
