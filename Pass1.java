class Pass1 {
    public static void main(String args[]) {
        int c = 0;  // Counter for non-empty symbols
        String[][] symbolTable = {
            {" ", "START", "101", " "}, 
            {" ", "MOVER", "BREG", " "}, 
            {"AGAIN", "MULT", "BREG", "TERM"}, 
            {" ", "MOVER", "CREG", "TERM"}, 
            {" ", "ADD", "CREG", "N"}, 
            {" ", "MOVEM", "CREG", "TERM"}, 
            {"N", "DS", "2", " "}, 
            {"RESULT", "DS", "2", " "}, 
            {"ONE", "DC", "1", " "}, 
            {"TERM", "DC", "1", " "}, 
            {" ", "END", " ", " "}
        };

        
        System.out.println("\n\t********SYMBOL TABLE********");
        System.out.println("\t____________________________");

        
        for (int i = 0; i < symbolTable.length; i++) { 
            for (int j = 0; j < symbolTable[i].length; j++) {
                System.out.print("\t" + symbolTable[i][j]); 
            }
            System.out.print("\n");  
        }

        System.out.print("\n");

        System.out.println("\t********NON-EMPTY SYMBOLS********");
        System.out.println("\t__________________________________");

 
        for (int k = 0; k < symbolTable.length; k++) {
            if (!symbolTable[k][0].equals(" ")) { 
                c += 1;  
                for (int l = 0; l < symbolTable[k].length; l++) {
                    System.out.print("\t" + symbolTable[k][l]);  
                }
                System.out.print("\n");  
            }
        }

        
        System.out.println("\nCounter of Non-Empty Symbols: " + c + "\n");
    }
}

