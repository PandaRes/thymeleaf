/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.standard.expression;

import org.thymeleaf.context.IProcessingContext;
import org.thymeleaf.exceptions.TemplateProcessingException;



/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 1.1 (reimplemented in 3.0.0)
 *
 */
public abstract class SimpleExpression extends Expression {
    
    private static final long serialVersionUID = 9145380484247069725L;
    
    
    static final char EXPRESSION_START_CHAR = '{';
    static final char EXPRESSION_END_CHAR = '}';
    
    
    
    protected SimpleExpression() {
        super();
    }
    
    


    
    
    
    static Object executeSimple(final IProcessingContext processingContext, final SimpleExpression expression,
            final IStandardVariableExpressionEvaluator expressionEvaluator, final StandardExpressionExecutionContext expContext) {
        
        if (expression instanceof VariableExpression) {
            return VariableExpression.executeVariable(processingContext, (VariableExpression)expression, expressionEvaluator, expContext);
        }
        if (expression instanceof MessageExpression) {
            return MessageExpression.executeMessage(processingContext, (MessageExpression)expression, expContext);
        }
        if (expression instanceof TextLiteralExpression) {
            return TextLiteralExpression.executeTextLiteral(processingContext, (TextLiteralExpression)expression, expContext);
        }
        if (expression instanceof NumberTokenExpression) {
            return NumberTokenExpression.executeNumberToken(processingContext, (NumberTokenExpression) expression, expContext);
        }
        if (expression instanceof BooleanTokenExpression) {
            return BooleanTokenExpression.executeBooleanToken(processingContext, (BooleanTokenExpression) expression, expContext);
        }
        if (expression instanceof NullTokenExpression) {
            return NullTokenExpression.executeNullToken(processingContext, (NullTokenExpression) expression, expContext);
        }
        if (expression instanceof LinkExpression) {
            return LinkExpression.executeLink(processingContext, (LinkExpression)expression, expContext);
        }
        if (expression instanceof SelectionVariableExpression) {
            return SelectionVariableExpression.executeSelectionVariable(processingContext, (SelectionVariableExpression)expression, expressionEvaluator, expContext);
        }
        if (expression instanceof GenericTokenExpression) {
            return GenericTokenExpression.executeGenericToken(processingContext, (GenericTokenExpression) expression, expContext);
        }

        throw new TemplateProcessingException("Unrecognized simple expression: " + expression.getClass().getName());
        
    }
    
}
