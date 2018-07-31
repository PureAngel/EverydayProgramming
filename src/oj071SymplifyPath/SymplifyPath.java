package oj071SymplifyPath;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Corner Cases:
 *
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 */

public class SymplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");
        for(int i = 0; i < paths.length; i++) {
            if(paths[i].length() == 0 || paths[i].equals(".")) {
                continue;
            }
            if(paths[i].equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    continue;
                }
            } else {
                stack.push(paths[i]);
            }
        }
        String res = "";
        for(String s: stack) {
            res += "/" + s;
        }

        if(res.equals("")) {
            return "/";
        }
        return res;
    }

    public static void main(String[] args) {
        String path = "/abc/...";
        SymplifyPath symplifyPath = new SymplifyPath();
        System.out.println(symplifyPath.simplifyPath(path));
    }
}
