package io.pivotal.pokedex.configuration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {
    private static final Log logger = LogFactory.getLog(JobConfiguration.class);

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("pokemon-battle")
                .start(stepBuilderFactory.get("all-the-things")
                        .tasklet((contribution, chunkContext) -> {
                            logger.info("Hello, Pallet Town");
                            return RepeatStatus.FINISHED;
                        })
                        .build()
                )
                .build();
    }
}
