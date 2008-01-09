package nz.ac.massey.take.takeep.editor;

import java.util.ArrayList;

import javax.annotation.processing.SupportedAnnotationTypes;

import nz.ac.massey.take.takeep.editor.tokens.TakePartitionScanner;
import nz.ac.massey.take.takeep.editor.tokens.TakePartitionScanner.TAKE_PARTITIONS;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.editors.text.FileDocumentProvider;
import org.eclipse.ui.texteditor.AnnotationPreference;


public class TakeDocumentProvider extends FileDocumentProvider {



	protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = super.createDocument(element);
		if (document != null) {
			ArrayList<String> strings = new ArrayList<String>();
			for(TAKE_PARTITIONS tp : TAKE_PARTITIONS.values())
			{
				strings.add(tp.name());
			}

			IDocumentPartitioner partitioner =
				new FastPartitioner(
					new TakePartitionScanner(),strings.toArray(new String[strings.size()]));

			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
		return document;
	}


	
}
