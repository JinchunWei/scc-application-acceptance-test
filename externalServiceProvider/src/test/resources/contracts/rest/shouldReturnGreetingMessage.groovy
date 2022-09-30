package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return Hello, World!"

    request {
        url "/message"
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
        body(id: anyPositiveInt(), message: "Hello, World!!")
    }
}
