package guru.sfg.springframework.msscbeerservice.services.order;

import guru.sfg.brewery.model.events.ValidateOrderRequest;
import guru.sfg.brewery.model.events.ValidateOrderResult;
import guru.sfg.springframework.msscbeerservice.config.JmsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;

@Component
@RequiredArgsConstructor
public class BeerOrderValidationListener {

    private final JmsTemplate jmsTemplate;
    private final BeerOrderValidator validator;

    @JmsListener(destination = JmsConfig.VALIDATE_ORDER_QUEUE)
    public void listenForOrderValidation(@Payload ValidateOrderRequest validateOrderRequest,
                                         @Headers MessageHeaders headers,
                                         Message message) {
        var isValid = validator.validateOrder(validateOrderRequest.getBeerOrder());

        jmsTemplate.convertAndSend(JmsConfig.VALIDATE_ORDER_RESULT_QUEUE,
                ValidateOrderResult.builder()
                        .isValid(isValid)
                        .orderId(validateOrderRequest.getBeerOrder().getId())
                        .build());

    }
}
