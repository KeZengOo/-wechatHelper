package com.nuoxin.virtual.rep.api.dao;

import com.nuoxin.virtual.rep.api.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by fenggang on 9/11/17.
 */
public interface QuestionRepository extends JpaRepository<Question,Long>,JpaSpecificationExecutor<Question> {

    /**
     * 修改试题删除状态
     * @param questionnaireId
     */
    @Modifying
    @Query("update Question q set q.delFlag=1  where q.questionnaireId=:questionnaireId")
    void deleteByQuestionnaireId(@Param("questionnaireId") Long questionnaireId);

    /**
     * 根据问卷id查询问题
     * @param questionnaireId
     */
    List<Question> findByQuestionnaireId(Long questionnaireId);

}