package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Should echo the request contents")

    request {
        url("/echo")
        method(POST())
        headers {
            accept(applicationJsonUtf8())
            contentType(applicationJsonUtf8())
        }
        body(
                name: $(consumer(regex("[a-zA-Z]+")), producer("Someone")),
                city: $(consumer(regex("[a-zA-Z]+")), producer("Ottawa"))
        )
    }

    response {
        status(OK())
        headers {
            contentType(applicationJsonUtf8())
        }
        body(
                name: fromRequest().body('$.name'),
                city: fromRequest().body('$.city')
        )
    }
}