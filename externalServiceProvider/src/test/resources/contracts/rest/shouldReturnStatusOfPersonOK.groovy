package contracts.rest

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description("Should return health check result is okay")

    request {
        url("/check")
        method(POST())
        headers {
            accept(applicationJsonUtf8())
            contentType(applicationJsonUtf8())
        }
        body(name: "Jane", age: 42)
        bodyMatchers {
            jsonPath('$.age', byRegex("[2-9][0-9]"))
            jsonPath('$.name', byRegex(".*"))
        }
    }

    response {
        status(OK())
        headers {
            contentType(applicationJson())
        }
        body(
                status: "OK"
        )
    }
}