package br.com.cateno.sdk.domain.messenger;

import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static dagger.internal.Preconditions.checkNotNull;

@Reusable
public class MessageService {

    private final MessageApiClient apiClient;

    @Inject
    public MessageService(final MessageApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    public Message create(final MessageRequest message) throws IOException {
        checkNotNull(message);

        final Call<Message> call = this.apiClient.create(message);
        final Response<Message> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public Message fetch(final UUID id) throws IOException {
        checkNotNull(id);

        final Call<Message> call = this.apiClient.findById(id.toString());
        final Response<Message> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public List<Message> list(int pageSize, int page) throws IOException {
        final Call<List<Message>> call = this.apiClient.findAll(pageSize, page);
        final Response<List<Message>> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
        return response.body();
    }

    public void readMessage(final UUID id, final MessageReadRequest message) throws IOException {
        checkNotNull(id);
        checkNotNull(message);

        final Call<Void> call = this.apiClient.readMessage(id.toString(), message);
        final Response<Void> response = call.execute();
        if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
    }
}
