/*******************************************************************************
 * Copyright (c) 2012-2015 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/

package de.fhrt.johannes.wendig.codenvy.bpmn.camunda;

import java.util.ArrayList;
import java.util.List;

public class CamundaTypeHolder {
	private List<CamundaFormKeyType> formKeyFiles;
	private List<CamundaJavaDelegateType> javaDelegateClasses;

	public CamundaTypeHolder() {
		super();
		formKeyFiles = new ArrayList<CamundaFormKeyType>();
		javaDelegateClasses = new ArrayList<CamundaJavaDelegateType>();
	}

	public List<CamundaFormKeyType> getFormKeyFiles() {
		return formKeyFiles;
	}

	public void setFormKeyFiles(List<CamundaFormKeyType> formKeyFiles) {
		this.formKeyFiles = formKeyFiles;
	}

	public List<CamundaJavaDelegateType> getJavaDelegateClasses() {
		return javaDelegateClasses;
	}

	public void setJavaDelegateClasses(
			List<CamundaJavaDelegateType> javaDelegateClasses) {
		this.javaDelegateClasses = javaDelegateClasses;
	}

}
