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
package org.thymeleaf.standard.processor;

import org.thymeleaf.context.ITemplateProcessingContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.exceptions.TemplateProcessingException;
import org.thymeleaf.inline.IInliner;
import org.thymeleaf.inline.NoOpInliner;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.standard.inline.StandardTextInliner;
import org.thymeleaf.standard.inline.StandardXMLInliner;
import org.thymeleaf.templatemode.TemplateMode;

/**
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 3.0.0
 *
 */
public final class StandardInlineXMLTagProcessor extends AbstractStandardTextInlineSettingTagProcessor {

    public static final int PRECEDENCE = 1000;
    public static final String ATTR_NAME = "inline";




    public StandardInlineXMLTagProcessor(final String dialectPrefix) {
        super(TemplateMode.XML, dialectPrefix, ATTR_NAME, PRECEDENCE);
    }



    @Override
    protected IInliner getInliner(
            final ITemplateProcessingContext processingContext, final IProcessableElementTag tag,
            final AttributeName attributeName, final String attributeValue, final Object expressionResult) {

        final String inliner = (expressionResult == null? null : expressionResult.toString().toLowerCase());

        if (inliner != null) {
            if (INLINE_MODE_NONE.equals(inliner)) {
                return NoOpInliner.INSTANCE;
            } else if (INLINE_MODE_XML.equals(inliner)) {
                return StandardXMLInliner.INSTANCE;
            } else if (INLINE_MODE_TEXT.equals(inliner)) {
                return StandardTextInliner.INSTANCE;
            }
        }

        throw new TemplateProcessingException(
                "Cannot recognize value for \"" + attributeName + "\". Allowed inline modes in template mode " +
                getTemplateMode() + " are: " +
                "\"" + INLINE_MODE_XML + "\", \"" + INLINE_MODE_TEXT + "\", " +
                "\"" + INLINE_MODE_NONE + "\"");

    }




}
