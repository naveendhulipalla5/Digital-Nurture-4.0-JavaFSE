package com.example;

public class Server {
	private ExternalAPI externalAPI;

    public Server(ExternalAPI externalAPI) {
        this.externalAPI = externalAPI;
    }

    public String fetchData() {
        return externalAPI.getData();
    }
}
