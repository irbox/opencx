package com.microsoft.graph.extensions;

import ax.N9.n0;
import com.microsoft.graph.generated.BaseNotebookCollectionResponse;
import com.microsoft.graph.http.IBaseCollectionPage;
import com.microsoft.graph.generated.BaseNotebookCollectionPage;

public class NotebookCollectionPage extends BaseNotebookCollectionPage implements IBaseCollectionPage
{
    public NotebookCollectionPage(final BaseNotebookCollectionResponse baseNotebookCollectionResponse, final n0 n0) {
        super(baseNotebookCollectionResponse, n0);
    }
}
