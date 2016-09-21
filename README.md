Install into local Maven repo with `gradle clean assemble install`

Add to data flow:
`dataflow:>app register --type task --name pokedex --uri maven://io.pivotal:pokedex:0.0.1-SNAPSHOT`