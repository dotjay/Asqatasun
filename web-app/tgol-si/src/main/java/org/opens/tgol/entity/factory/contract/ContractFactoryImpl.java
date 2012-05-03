/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2011  Open-S Company
 *
 * This file is part of Tanaguru.
 *
 * Tanaguru is free software: you can redistribute it and/or modify
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
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tgol.entity.factory.contract;

import java.util.Date;
import java.util.Set;
import org.opens.tgol.entity.contract.Contract;
import org.opens.tgol.entity.contract.ContractImpl;
import org.opens.tgol.entity.functionality.Functionality;
import org.opens.tgol.entity.option.OptionElement;
import org.opens.tgol.entity.referential.Referential;
import org.opens.tgol.entity.scenario.Scenario;
import org.opens.tgol.entity.user.User;

/**
 *
 * @author jkowalczyk
 */
public class ContractFactoryImpl implements ContractFactory {

    @Override
    public Contract createContract(
            String label,
            Date beginDate,
            Date endDate,
            Date renewalDate,
            Float price,
            Set<? extends Functionality> functionalitySet, 
            Set<? extends OptionElement> optionElementSet, 
            Set<? extends Referential> referentialSet, 
            Set<? extends Scenario> ScenarioSet, 
            User user) {
        Contract contract = create();
        contract.setLabel(label);
        contract.setBeginDate(beginDate);
        contract.setEndDate(endDate);
        contract.setRenewalDate(renewalDate);
        contract.addAllFunctionality(functionalitySet);
        contract.addAllOptionElement(optionElementSet);
        contract.addAllReferential(referentialSet);
        contract.addAllScenario(ScenarioSet);
        contract.setPrice(price);
        return contract;
    }

    @Override
    public Contract create() {
        return new ContractImpl();
    }

}