package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return Hello with a name!"

    request {
        url("/message") {
            queryParameters {
                parameter("name",
                        $(consumer(regex("[a-zA-Z]+")), producer("Victor"))
                )
            }
        }
        method GET()
        headers {
            accept(applicationJson())
        }

    }

    response {
        status(OK())
        headers {
            contentType(applicationJson())
        }
        body(
                id: $(stub(anyPositiveInt()), producer(anyPositiveInt())),
                message: $(
                        stub("Hello, ${fromRequest().query("name")}!!"),
                        producer("Hello, ${fromRequest().query("name")}!!")
                ))
    }
}
