package cn.ieclipse.smartim.views;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public class CheckBoxTreeNodeSelectionListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent event) {
        JTree tree = (JTree) event.getSource();
        int x = event.getX();
        int y = event.getY();
        int row = tree.getRowForLocation(x, y);
        TreePath path = tree.getPathForRow(row);
        if (path != null) {
            DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path
                    .getLastPathComponent();
            if (selectedNode != null && selectedNode.getChildCount() > 0
                    && event.getClickCount() > 1) {
                // if (tree.isExpanded(path)) {
                // tree.collapsePath(path);
                // }
                // else {
                // tree.expandPath(path);
                // }
                return;
            }
            else if (selectedNode instanceof CheckBoxTreeNode
                    && event.getClickCount() == 1) {
                CheckBoxTreeNode node = (CheckBoxTreeNode) selectedNode;
                if (node != null) {
                    boolean isSelected = !node.isSelected();
                    node.setSelected(isSelected);
                    ((DefaultTreeModel) tree.getModel())
                            .nodeStructureChanged(node);
                }
            }
        }
    }
}