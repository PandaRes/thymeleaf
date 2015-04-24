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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.IProcessingContext;


/**
 * 
 * @author Daniel Fern&aacute;ndez
 * 
 * @since 2.1.0 (reimplemented in 3.0.0)
 *
 */
public final class NullTokenExpression extends Token {

    private static final Logger logger = LoggerFactory.getLogger(NullTokenExpression.class);

    private static final long serialVersionUID = -927282151625647619L;

    private static final NullTokenExpression SINGLETON = new NullTokenExpression();


    public NullTokenExpression() {
        super(null);
    }



    @Override
    public String getStringRepresentation() {
        return "null";
    }


    
    static NullTokenExpression parseNullToken(final String input) {
        if ("null".equalsIgnoreCase(input)) {
            return SINGLETON;
        }
        return null;
    }
    

    
    static Object executeNullToken(
            @SuppressWarnings("unused") final IProcessingContext processingContext,
            final NullTokenExpression expression,
            @SuppressWarnings("unused") final StandardExpressionExecutionContext expContext) {

        if (logger.isTraceEnabled()) {
            logger.trace("[THYMELEAF][{}] Evaluating null token: \"{}\"", TemplateEngine.threadIndex(), expression.getStringRepresentation());
        }
        
        return expression.getValue();
        
    }
    
}
