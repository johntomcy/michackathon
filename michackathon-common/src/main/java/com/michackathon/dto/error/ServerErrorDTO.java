package com.michackathon.dto.error;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Tomcy John
 */
public class ServerErrorDTO {
    private String error;
    private String description;
    private List<Object> details = Lists.newArrayList();

    public ServerErrorDTO() {
    }

    public ServerErrorDTO(String error, String description, List<Object> details) {
        this.error = error;
        this.description = description;
        this.details = details;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getDetails() {
        return details;
    }

    public void setDetails(List<Object> details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServerErrorDTO that = (ServerErrorDTO) o;

        if (error != null ? !error.equals(that.error) : that.error != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return details != null ? details.equals(that.details) : that.details == null;

    }

    @Override
    public int hashCode() {
        int result = error != null ? error.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }
}
