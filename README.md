# Observability Demo

## Start Applications

- By Docker-compose

```shell
docker-compose build my-kotlin-app
docker-compose up
```

- By k8s

```shell
./setup-k8s
```


## Metrics
  - [prometheus](http://0.0.0.0:3000/explore?schemaVersion=1&panes=%7B%22ylu%22:%7B%22datasource%22:%22PBFA97CFB590B2093%22,%22queries%22:%5B%7B%22refId%22:%22A%22,%22expr%22:%22%7Bmetrics_collector%3D%5C%22prometheus%5C%22,%20origin%3D%5C%22otel%5C%22,%20app%3D%5C%22my-kotlin-app%5C%22,%20__name__%3D~%5C%22jvm.%2A%5C%22%7D%22,%22range%22:true,%22datasource%22:%7B%22type%22:%22prometheus%22,%22uid%22:%22PBFA97CFB590B2093%22%7D,%22editorMode%22:%22code%22,%22legendFormat%22:%22__auto%22,%22useBackend%22:false,%22disableTextWrap%22:false,%22fullMetaSearch%22:false,%22includeNullMetadata%22:true%7D%5D,%22range%22:%7B%22from%22:%22now-15m%22,%22to%22:%22now%22%7D%7D%7D&orgId=1)
  - [otlp](http://0.0.0.0:3000/explore?schemaVersion=1&panes=%7B%22ylu%22:%7B%22datasource%22:%22PBFA97CFB590B2093%22,%22queries%22:%5B%7B%22refId%22:%22A%22,%22expr%22:%22%7Bmetrics_collector%3D%5C%22otlp%5C%22,%20job%3D%5C%22my-kotlin-app%5C%22,%20__name__%3D~%5C%22jvm.%2A%5C%22%7D%22,%22range%22:true,%22datasource%22:%7B%22type%22:%22prometheus%22,%22uid%22:%22PBFA97CFB590B2093%22%7D,%22editorMode%22:%22code%22,%22legendFormat%22:%22__auto%22,%22useBackend%22:false,%22disableTextWrap%22:false,%22fullMetaSearch%22:false,%22includeNullMetadata%22:true%7D%5D,%22range%22:%7B%22from%22:%22now-15m%22,%22to%22:%22now%22%7D%7D%7D&orgId=1)
  - [custom otlp metrics](http://0.0.0.0:3000/explore?schemaVersion=1&panes=%7B%22ylu%22:%7B%22datasource%22:%22PBFA97CFB590B2093%22,%22queries%22:%5B%7B%22refId%22:%22A%22,%22expr%22:%22%7Bmetrics_collector%3D%5C%22otlp%5C%22,%20job%3D%5C%22my-kotlin-app%5C%22,%20__name__%3D%5C%22person_hello_count_total%5C%22%7D%22,%22range%22:true,%22datasource%22:%7B%22type%22:%22prometheus%22,%22uid%22:%22PBFA97CFB590B2093%22%7D,%22editorMode%22:%22code%22,%22legendFormat%22:%22__auto%22,%22useBackend%22:false,%22disableTextWrap%22:false,%22fullMetaSearch%22:false,%22includeNullMetadata%22:true%7D%5D,%22range%22:%7B%22from%22:%22now-15m%22,%22to%22:%22now%22%7D%7D%7D&orgId=1)

## Logging
- [Link](http://0.0.0.0:3000/explore?schemaVersion=1&panes=%7B%22ylu%22:%7B%22datasource%22:%22P8E80F9AEF21F6940%22,%22queries%22:%5B%7B%22refId%22:%22A%22,%22expr%22:%22%7Bservice_name%3D%5C%22my-kotlin-app%5C%22%7D%22,%22queryType%22:%22range%22,%22datasource%22:%7B%22type%22:%22loki%22,%22uid%22:%22P8E80F9AEF21F6940%22%7D,%22editorMode%22:%22code%22,%22direction%22:%22backward%22%7D%5D,%22range%22:%7B%22from%22:%22now-15m%22,%22to%22:%22now%22%7D,%22panelsState%22:%7B%22logs%22:%7B%22visualisationType%22:%22logs%22%7D%7D%7D%7D&orgId=1)
