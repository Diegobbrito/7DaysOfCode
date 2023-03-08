package dto;

import java.util.List;

public class FullResponse {
        private List<MoviesResponse> items;
        private String errorMessage;

    public FullResponse(List<MoviesResponse> items, String errorMessage) {
        this.items = items;
        this.errorMessage = errorMessage;
    }

    public List<MoviesResponse> getItems() {
        return items;
    }

    public void setItems(List<MoviesResponse> items) {
        this.items = items;
    }

    public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

