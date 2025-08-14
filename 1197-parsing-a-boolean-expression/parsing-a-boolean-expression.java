class Solution {
    public boolean parseBoolExpr(String expression) {
    Deque<Character> stack = new ArrayDeque<>();
    for(char ch: expression.toCharArray() ){
        if(ch == ',') continue;
        if(ch != ')'){
            stack.push(ch);
            continue;
        }
        List<Character> vals = new ArrayList<>();
        while(!stack.isEmpty() && stack.peek() != '('){
            vals.add(stack.pop());
        }
        stack.pop();
        char op = stack.pop();
        char result ;
        if(op == '!'){
            result = (vals.get(0) == 't') ? 'f' : 't';
            } else if (op == '&') {
                boolean allTrue = true;
                for (char v : vals) {
                    if (v == 'f') { allTrue = false; break; }
                }
                result = allTrue ? 't' : 'f';
            } else { 
                  boolean anyTrue = false;
                for (char v : vals) {
                    if (v == 't') { anyTrue = true; break; }
                }
                result = anyTrue ? 't' : 'f';
            }
            stack.push(result);
        }
        return stack.pop() == 't';
    }
    
}