(:JIQS: ShouldCrash; ErrorCode="XQDY0027"; :)
annotate(
    structured-json-file("../../../../queries/rumbleML/sample-ml-data-age-weight.json"),
    {"id": "decimal", "age": "decimal", "weight": "double", "i-should-not-exist": null}
)

(: schema has extra fields :)
