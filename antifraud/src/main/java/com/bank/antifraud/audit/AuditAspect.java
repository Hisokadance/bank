package com.bank.antifraud.audit;

import com.bank.antifraud.entity.Audit;
import com.bank.antifraud.repository.AuditRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

/**
 * Аспект для регистрации аудита после выполнения методов сервиса.
 */
@Aspect
@RequiredArgsConstructor
@Component
public class AuditAspect {

    private final AuditRepository auditRepository; // Репозиторий аудита
    private final ObjectMapper objectMapper;

    /**
     * Точка среза для всех методов в пакете сервисов.
     */
    @Pointcut("execution(* com.bank.antifraud.service.*.*(..))")
    public void serviceMethods() {
    }

    /**
     * Аспект, вызываемый после успешного выполнения методов сервисов.
     *
     * @param joinPoint точка присоединения, содержащая информацию о вызове метода
     * @param result    результат выполнения метода
     */
    @AfterReturning(pointcut = "serviceMethods()", returning = "result")
    public void afterServiceMethodExecution(JoinPoint joinPoint, Object result) throws JsonProcessingException {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        // Получаем информацию о текущем пользователе, если доступно, иначе используем заглушку
        String currentUser = "Игорес"; // По умолчанию система

        // Получаем текущее время
        OffsetDateTime currentTime = OffsetDateTime.now();
        // Заполнение данных из сервисов в JSON
        String json = objectMapper.writeValueAsString(result);

        // Создаем объект аудита
        Audit audit = new Audit();
        audit.setEntityType(className);
        audit.setOperationType(methodName);
        audit.setCreatedBy(currentUser);
        audit.setCreatedAt(currentTime);
        audit.setModifiedAt(currentTime);
        audit.setModifiedBy(currentUser);
        audit.setEntityJson(json);
        audit.setNewEntityJson(json);
        /**
         * можно сделать setNewEntityJson: если пришёл с сервиса обновления, то сравни с текущим json если не равны то добавь, но лень)
         */

        // Сохраняем информацию об аудите в базе данных
        auditRepository.save(audit);
    }
}
