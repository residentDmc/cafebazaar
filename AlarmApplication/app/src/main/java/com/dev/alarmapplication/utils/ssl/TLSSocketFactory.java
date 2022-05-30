package com.dev.alarmapplication.utils.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class TLSSocketFactory extends SSLSocketFactory {
    private final SSLSocketFactory internalSSLSocketFactory;

    public TLSSocketFactory(SSLSocketFactory delegate) {
        internalSSLSocketFactory = delegate;
    }

    @Override
    public String[] getDefaultCipherSuites() {
        return internalSSLSocketFactory.getDefaultCipherSuites();
    }

    @Override
    public String[] getSupportedCipherSuites() {
        return internalSSLSocketFactory.getSupportedCipherSuites();
    }

    @Override
    public Socket createSocket(Socket s, String host, int port, boolean autoClose) throws IOException {
        return enableTLSOnSocket(internalSSLSocketFactory.createSocket(s, host, port, autoClose));
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return enableTLSOnSocket(internalSSLSocketFactory.createSocket(host, port));
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws IOException {
        return enableTLSOnSocket(internalSSLSocketFactory.createSocket(host, port, localHost, localPort));
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return enableTLSOnSocket(internalSSLSocketFactory.createSocket(host, port));
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort) throws IOException {
        return enableTLSOnSocket(internalSSLSocketFactory.createSocket(address, port, localAddress, localPort));
    }

    /*
     * Utility methods
     */

    private static Socket enableTLSOnSocket(Socket socket) {
        if ((socket instanceof SSLSocket)
                && isTLSServerEnabled((SSLSocket) socket)) { // skip the fix if server doesn't provide there TLS version
            ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLS_v1_1", "TLS_v1_2"});
        }
        return socket;
    }

    private static boolean isTLSServerEnabled(SSLSocket sslSocket) {
        System.out.println("__prova__ :: " + Arrays.toString(sslSocket.getSupportedProtocols()));
        for (String protocol : sslSocket.getSupportedProtocols()) {
            if (protocol.equals("TLS_v1_1") || protocol.equals("TLS_v1_2")) {
                return true;
            }
        }
        return false;
    }
}
