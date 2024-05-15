package com.preorder.web.product.redis;

import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Spring Expression Language Parser
 * => CustomSpringELParser 는 전달받은 Lock의 이름을
 *    Spring Expression Language 로 파싱하여 읽어옴
 * => Spring Expression Language를 사용하면 다음과 같이
 *    Lock의 이름을 보다 자유롭게 전달할 수 있음
 */
public class CustomSpringELParser {
    private CustomSpringELParser() {
    }

    public static Object getDynamicValue(String[] parameterNames, Object[] args, String key) {
        ExpressionParser parser = new SpelExpressionParser();
        StandardEvaluationContext context = new StandardEvaluationContext();

        // parameterNames가 null이 아닌지 확인
        if (parameterNames != null) {
            for (int i = 0; i < parameterNames.length; i++) {
                if (args != null && i < args.length) { // args 배열도 null이 아니고, 범위를 벗어나지 않는지 확인
                    context.setVariable(parameterNames[i], args[i]);
                }
            }
        }

        return parser.parseExpression(key).getValue(context, Object.class);
    }
}