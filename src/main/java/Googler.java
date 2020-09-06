import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.ui.Messages;
import org.jetbrains.annotations.NotNull;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.net.URLEncoder;



public class Googler extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        //Messages.showMessageDialog("Hello", "Googler Action", Messages.getInformationIcon());
        //Editor editor = event.getData(PlatformDataKeys.EDITOR);
        Editor editor = e.getData(PlatformDataKeys.EDITOR);
        String selectedText = editor.getSelectionModel().getSelectedText();
        if (selectedText != null) {
            String encoded = "";
            try {
                encoded = URLEncoder.encode(selectedText, StandardCharsets.UTF_8.toString());
            } catch (UnsupportedEncodingException unsupportedEncodingException) {
                unsupportedEncodingException.printStackTrace();
            }

            String url = String.format("https://www.google.com/search?q=%s", encoded);
            //Messages.showMessageDialog(url, "Googler Action", Messages.getInformationIcon());
            BrowserUtil.browse(url);
        }
        else {
            Messages.showMessageDialog("Selection is empty, could you please to select something.", "Googler Action", Messages.getInformationIcon());
        }
        //https://www.google.com/search?q=
    }

    @Override
    public boolean isDumbAware() {
        return false;
    }
}
