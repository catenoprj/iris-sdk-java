package br.com.cateno.sdk.domain.messenger;

import br.com.cateno.sdk.infra.ApiResponseBody;
import dagger.Reusable;
import retrofit2.Call;
import retrofit2.Response;

import javax.inject.Inject;
import java.io.IOException;
import java.util.List;

import static dagger.internal.Preconditions.checkNotNull;

/**
 * Provides the local service for accessing, adding and updating a Message
 */
@Reusable
public class MessageService {

    private final MessageApiClient apiClient;

    @Inject
    public MessageService(final MessageApiClient apiClient) {
        checkNotNull(apiClient);
        this.apiClient = apiClient;
    }

    /**
     * Create a new Message
     *
     * @param message object necessary to create a new Message
     * @return Message that was created
     * @throws IOException does occur if response by server for unsuccessful
     * @see MessageRequest
     * @see Message
     */
    public Message create(final MessageRequest message) throws IOException {
        checkNotNull(message);

        final Call<Message> call = this.apiClient.create(message);
        final Response<Message> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Fetch an Message by Id existent
     *
     * @param id Message already created
     * @return Message that was found
     * @throws IOException does occur if response by server for unsuccessful
     * @see Message
     */
    public Message fetch(final String id) throws IOException {
        checkNotNull(id);

        final Call<Message> call = this.apiClient.findById(id);
        final Response<Message> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Fetch all Messages
     *
     * @param filters object necessary to filter messages
     * @param pagination object necessary to define quantity messages
     * @return list of Messages
     * @throws IOException does occur if response by server for unsuccessful
     * @see MessageFilters
     * @see Pagination
     * @see Message
     */
    public List<Message> list(final MessageFilters filters, final Pagination pagination) throws IOException {
        checkNotNull(filters);
        checkNotNull(pagination);

        final Call<List<Message>> call = this.apiClient.findAll(filters, pagination.getLimit(), pagination.getOffset());
        final Response<List<Message>> response = call.execute();
        return new ApiResponseBody<>(response).successfulBodyOrThrow();
    }

    /**
     * Mark a message as read
     *
     * @param id Message already created
     * @throws IOException does occur if response by server for unsuccessful
     */
    public void markAsRead(final String id) throws IOException {
        checkNotNull(id);

        final Call<Void> call = this.apiClient.update(id, true);
        final Response<Void> response = call.execute();
        new ApiResponseBody<>(response).successfulBodyOrThrow();
    }
}
