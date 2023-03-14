package dto;

import java.util.List;

public class ImdbFullResponse {
        private List<ImdbMoviesResponse> items;
        private String errorMessage;

    public ImdbFullResponse(List<ImdbMoviesResponse> items, String errorMessage) {
        this.items = items;
        this.errorMessage = errorMessage;
    }

    public List<ImdbMoviesResponse> getItems() {
        return items;
    }

    public void setItems(List<ImdbMoviesResponse> items) {
        this.items = items;
    }

    public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

