package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Should return health check result")

    request {
        url("/check")
        method(POST())
        headers {
            accept(applicationJsonUtf8())
            contentType(applicationJsonUtf8())
        }
        body(name: "Jinchun", age: 12)
        bodyMatchers {
            jsonPath('$.age', byRegex("[0-1][0-9]"))
            jsonPath('$.name', byRegex(".*"))
        }
    }

    response {
        status(OK())
        headers {
            contentType(applicationJson())
        }
        body(
                status: "NOT_OK"
        )
    }
}