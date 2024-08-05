package com.wootecam.jspcafe.domain;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository {

    Long save(Reply reply);

    Optional<Reply> findById(Long id);

    List<Reply> findAllByQuestionPrimaryId(Long questionId);

    void delete(Long id);

    boolean existsReplyByIdAndOtherUserPrimaryId(final Long id, Long userPrimaryId);

    void deleteAllByQuestionPrimaryId(Long questionPrimaryId);
}
