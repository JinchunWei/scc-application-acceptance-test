package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Should return health check result")

    request {
        url("/healthcheck")
        method(GET())
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
                status: $(
                        consumer("STARTING"),
                        producer(anyOf("RUNNING", "STARTING", "STOPPING", "STOPPED"))
                )
        )
    }
}