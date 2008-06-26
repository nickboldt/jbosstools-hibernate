/*******************************************************************************
 * Copyright (c) 2007 Exadel, Inc. and Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Exadel, Inc. and Red Hat, Inc. - initial API and implementation
 ******************************************************************************/ 
package org.jboss.tools.hibernate.internal.core.hibernate.descriptors;

import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.jboss.tools.hibernate.core.IPersistentField;
import org.jboss.tools.hibernate.core.OrmCore;
import org.jboss.tools.hibernate.internal.core.properties.DBTablePropertyDescriptor;
import org.jboss.tools.hibernate.internal.core.properties.PropertyDescriptorsHolder;


/**
 * @author kaa
 * akuzmin@exadel.com
 * Sep 27, 2005
 */
public class BagMappingDescriptorsHolderWithTable extends
		BagMappingDescriptorsHolder {
	private static BagMappingDescriptorsHolderWithTable instance;
	private static final String GENERAL_CATEGORY=Messages.BagMappingDescriptorsHolderWithTable_GeneralCategory;
	public static PropertyDescriptorsHolder getInstance(IPersistentField pfm){
		instance=new BagMappingDescriptorsHolderWithTable(pfm);
		return instance;
	}
	
	
	protected BagMappingDescriptorsHolderWithTable(IPersistentField pfm) {
		super();
		PropertyDescriptor pd;
		if (pfm.getOwnerClass()!=null)
		{
		pd=new DBTablePropertyDescriptor("collectionTable",Messages.BagMappingDescriptorsHolderWithTable_CollectionTableN,null,pfm.getOwnerClass().getPersistentClassMapping(),pfm); //$NON-NLS-1$
		pd.setDescription(Messages.BagMappingDescriptorsHolderWithTable_CollectionTableD);
		pd.setCategory(GENERAL_CATEGORY);
		addPropertyDescriptor(pd);
		} else {
			OrmCore.getPluginLog().logInfo("Field "+pfm.getName()+" hasn't owner class");	 //$NON-NLS-1$ //$NON-NLS-2$
		}

	}

}
