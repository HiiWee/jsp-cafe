package com.wootecam.jspcafe.service.fixture;

import com.wootecam.jspcafe.config.DataSourceManager;
import com.wootecam.jspcafe.config.JdbcTemplate;
import com.wootecam.jspcafe.domain.QuestionRepository;
import com.wootecam.jspcafe.domain.UserRepository;
import com.wootecam.jspcafe.repository.JdbcQuestionRepository;
import com.wootecam.jspcafe.repository.JdbcUserRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ServiceTest {

    private DataSourceManager dataSourceManager;

    protected JdbcTemplate jdbcTemplate;

    protected UserRepository userRepository;

    protected QuestionRepository questionRepository;

    protected DatabaseCleaner databaseCleaner;

    @BeforeEach
    void setUpTest() {
        dataSourceManager = new DataSourceManager();
        jdbcTemplate = new JdbcTemplate(dataSourceManager);
        databaseCleaner = new DatabaseCleaner(jdbcTemplate);
        userRepository = new JdbcUserRepository(jdbcTemplate);
        questionRepository = new JdbcQuestionRepository(jdbcTemplate);
    }

    @AfterEach
    void cleanDatabase() {
        databaseCleaner.clean();
    }

    @AfterAll
    void closeDataSourceManager() {
        dataSourceManager.shutdown();
    }
}
