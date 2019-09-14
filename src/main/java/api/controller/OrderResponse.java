package api.controller;

import java.util.List;

public class OrderResponse {
    private List<OrderResult> results;

    public OrderResponse(List<OrderResult> results) {
        this.results = results;
    }

    public List<OrderResult> getResults() {
        return results;
    }

    public void setResults(List<OrderResult> results) {
        this.results = results;
    }
}
