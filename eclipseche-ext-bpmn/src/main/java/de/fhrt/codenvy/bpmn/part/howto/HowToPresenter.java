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
package de.fhrt.codenvy.bpmn.part.howto;

import org.eclipse.che.ide.api.parts.AbstractPartPresenter;
import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Show information how to use notification tutorial.
 *
 * @author <a href="mailto:aplotnikov@codenvy.com">Andrey Plotnikov</a>
 */
@Singleton
public class HowToPresenter extends AbstractPartPresenter implements
		HowToView.ActionDelegate {
	private HowToView view;

	@Inject
	public HowToPresenter(HowToView view) {
		this.view = view;
		this.view.setDelegate(this);
	}

	/** {@inheritDoc} */
	@Override
	public String getTitle() {
		return "Editor API";
	}

	/** {@inheritDoc} */
	@Override
	public ImageResource getTitleImage() {
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public SVGResource getTitleSVGImage() {
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public String getTitleToolTip() {
		return null;
	}

	/** {@inheritDoc} */
	@Override
	public void go(AcceptsOneWidget container) {
		container.setWidget(view);
	}

	@Override
	public void setVisible(boolean visible) {

	}

	@Override
	public IsWidget getView() {
		return view;
	}
}