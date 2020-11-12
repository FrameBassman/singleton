package tech.romashov.generator

class Program {
    static void main(String[] args) {
        def domain = new DomainTestGenerator()
        def pipeline = new PipelineTestGenerator()
        domain.run()
        pipeline.run()
    }
}
