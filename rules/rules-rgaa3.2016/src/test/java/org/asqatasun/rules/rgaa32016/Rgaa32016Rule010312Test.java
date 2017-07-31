/*
 * Asqatasun - Automated webpage assessment
 * Copyright (C) 2008-2015  Asqatasun.org
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: asqatasun AT asqatasun DOT org
 */
package org.asqatasun.rules.rgaa32016;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.asqatasun.entity.audit.TestSolution;
import org.asqatasun.entity.audit.ProcessResult;
import static org.asqatasun.rules.keystore.HtmlElementStore.CANVAS_ELEMENT;
import static org.asqatasun.rules.keystore.HtmlElementStore.TEXT_ELEMENT2;
import static org.asqatasun.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.asqatasun.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.asqatasun.rules.keystore.RemarkMessageStore.CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_INFORMATIVE_IMAGE_MSG;
import static org.asqatasun.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_AT_RESTITUTION_OF_ALTERNATIVE_MSG;
import org.asqatasun.rules.rgaa32016.test.Rgaa32016RuleImplementationTestCase;

/**
 * Unit test class for the implementation of the rule 1.3.12 of the referential RGAA 3.2016
 *
 * @author
 */
public class Rgaa32016Rule010312Test extends Rgaa32016RuleImplementationTestCase {

    /**
     * Default constructor
     * @param testName
     */
    public Rgaa32016Rule010312Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.asqatasun.rules.rgaa32016.Rgaa32016Rule010312");
    }

    @Override
    protected void setUpWebResourceMap() {
        addWebResource("Rgaa32016.Test.01.03.08-3NMI-01");
        addWebResource("Rgaa32016.Test.01.03.08-3NMI-02",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "id-informative-image"));
        addWebResource("Rgaa32016.Test.01.03.08-3NMI-03",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-image"));
        addWebResource("Rgaa32016.Test.01.03.08-3NMI-04",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "role-informative-image"));
        addWebResource("Rgaa32016.Test.01.03.08-4NA-01");
        addWebResource("Rgaa32016.Test.01.03.08-4NA-02");
        addWebResource("Rgaa32016.Test.01.03.08-4NA-03",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "class-informative-image"));
        addWebResource("Rgaa32016.Test.01.03.08-4NA-04",
                createParameter("Rules", INFORMATIVE_IMAGE_MARKER, "role-informative-image"));
        addWebResource("Rgaa32016.Test.01.03.08-4NA-05",
                createParameter("Rules", DECORATIVE_IMAGE_MARKER, "id-decorative-image"));
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("Rgaa32016.Test.01.03.08-3NMI-01");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_NATURE_OF_IMAGE_AND_AT_RESTITUTION_OF_ALTERNATIVE_MSG,
                CANVAS_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "Un text"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        
        processResult = processPageTest("Rgaa32016.Test.01.03.08-3NMI-02");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_INFORMATIVE_IMAGE_MSG,
                CANVAS_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "Un text"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32016.Test.01.03.08-3NMI-03");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_INFORMATIVE_IMAGE_MSG,
                CANVAS_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "Un text"));
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("Rgaa32016.Test.01.03.08-3NMI-04");
        checkResultIsPreQualified(processResult, 1, 1);
        checkRemarkIsPresent(
                processResult,
                TestSolution.NEED_MORE_INFO,
                CHECK_AT_RESTITUTION_OF_ALTERNATIVE_OF_INFORMATIVE_IMAGE_MSG,
                CANVAS_ELEMENT,
                1,
                new ImmutablePair(TEXT_ELEMENT2, "Un text"));

        //----------------------------------------------------------------------
        //------------------------------4NA-01----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32016.Test.01.03.08-4NA-01"));

        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32016.Test.01.03.08-4NA-02"));

        //----------------------------------------------------------------------
        //------------------------------4NA-03----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32016.Test.01.03.08-4NA-03"));

        //----------------------------------------------------------------------
        //------------------------------4NA-04----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32016.Test.01.03.08-4NA-04"));

        //----------------------------------------------------------------------
        //------------------------------4NA-05----------------------------------
        //----------------------------------------------------------------------
        checkResultIsNotApplicable(processPageTest("Rgaa32016.Test.01.03.08-4NA-05"));
    }

}