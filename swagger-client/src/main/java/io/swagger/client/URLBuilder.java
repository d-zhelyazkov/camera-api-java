package io.swagger.client;

import com.squareup.okhttp.HttpUrl;
import io.swagger.annotations.SwaggerDefinition;

public class URLBuilder {

    public static final String LOCALHOST = "localhost";

    private final HttpUrl.Builder okhttpBuilder = new HttpUrl.Builder();

    public URLBuilder() {
        okhttpBuilder.host(LOCALHOST);
    }

    public URLBuilder scheme(SwaggerDefinition.Scheme scheme) {
        okhttpBuilder.scheme(scheme.toString());
        return this;
    }

    public URLBuilder host(String host) {
        okhttpBuilder.host(host);
        return this;
    }

    public URLBuilder port(int port) {
        okhttpBuilder.port(port);
        return this;
    }

    public URLBuilder addPathSegment(String pathSegment) {
        pathSegment = pathSegment.replaceAll("^/", "");
        pathSegment = pathSegment.replaceAll("/$", "");

        okhttpBuilder.addPathSegment(pathSegment);
        return this;
    }

    @Override
    public String toString() {
        return okhttpBuilder.toString();
    }
}
