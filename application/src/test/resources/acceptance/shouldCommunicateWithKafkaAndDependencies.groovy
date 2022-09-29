package acceptance

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Should Interact with dependencies and return right response")

    request {
        url("/greeting") {
            queryParameters {
                parameter(
                    "name", $(consumer(regex("[a-zA-Z]+")), producer("Jinchun"))
                )
            }
        }
        method(GET())
        headers {
            accept(applicationJsonUtf8())
        }
    }

    response {
        status(OK())
        headers {
            contentType(applicationJsonUtf8())
        }
        body(
            id: $(consumer(anyPositiveInt()), producer(anyPositiveInt())),
            greeting: "Hello, ${fromRequest().query("name")}!!"
        )
    }
}
