package com.security.securityecommerce.JWT;

import java.io.FileReader;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

public class KeyUtil {


    public static PrivateKey readPrivateKey(String filename) throws Exception {
        try (PEMParser pemParser = new PEMParser(new FileReader(filename))) {
            Object object = pemParser.readObject();

            if (object instanceof PrivateKeyInfo) {
                PrivateKeyInfo keyInfo = (PrivateKeyInfo) object;
                return new JcaPEMKeyConverter().getPrivateKey(keyInfo);
            } else {
                throw new IllegalArgumentException("Invalid private key format.");
            }
        }}

        public static PublicKey readPublicKey(String filename) throws Exception {
            try (PEMParser pemParser = new PEMParser(new FileReader(filename))) {
                Object object = pemParser.readObject();

                if (object instanceof SubjectPublicKeyInfo) {
                    SubjectPublicKeyInfo keyInfo = (SubjectPublicKeyInfo) object;
                    return new JcaPEMKeyConverter().getPublicKey(keyInfo);
                } else {
                    throw new IllegalArgumentException("Invalid public key format.");
                }
            }
}}
