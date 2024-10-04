package com.restful.todo.list.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Classe que encapsula os detalhes de um erro ocorrido durante o processamento
 * de uma requisição na aplicação.
 * <p>
 * Esta classe é utilizada para padronizar as informações retornadas ao cliente
 * quando uma exceção é lançada, facilitando a identificação do erro e
 * a resolução do problema.
 * </p>
 *
 * <p>Os detalhes do erro incluem:</p>
 * <ul>
 *     <li>{@link #timestamp} - A data e hora em que o erro ocorreu.</li>
 *     <li>{@link #message} - A mensagem de erro que descreve o problema ocorrido.</li>
 *     <li>{@link #details} - Detalhes adicionais sobre o erro, como a URI da requisição
 *     ou a descrição da exceção.</li>
 *     <li>{@link #errorCode} - O código ou tipo do erro ocorrido, facilitando a
 *     categorização do problema.</li>
 * </ul>
 *
 * <p>Exemplo de uso:</p>
 * <pre>
 *     {@code
 *     ErrorDetails errorDetails = new ErrorDetails(
 *         LocalDateTime.now(),
 *         "O valorTotalParcial fornecido para o campo 'email' já está em uso.",
 *         "uri=/usuarios",
 *         "DUPLICATE_ENTRY"
 *     );
 *     }
 * </pre>
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Detalhes de um erro ocorrido durante o processamento de uma requisição.")
public class ErrorDetails {
    @Schema(description = "Data e hora em que o erro ocorreu.")
    private LocalDateTime timestamp;

    @Schema(description = "Mensagem de erro que descreve o problema ocorrido.")
    private String message;

    @Schema(description = "Detalhes adicionais sobre o erro.")
    private String details;

    @Schema(description = "Código ou tipo do erro ocorrido.")
    private String errorCode;
}
