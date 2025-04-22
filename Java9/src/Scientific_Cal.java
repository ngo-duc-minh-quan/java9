/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.function.Function;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author PC MSI
 */
public class Scientific_Cal extends javax.swing.JFrame {
double firstnum;
double secondnum;
double result;
private double currentResult = 0.0;
private double giaTriX;
String operations;
private Object math;
private String lichSuTinhToan = "";
private boolean isResultShown = false; 
private String lastResult = "0";
private boolean isResultDisplayed = false;
BigDecimal firstBigNum = BigDecimal.ZERO;
boolean isBigNumber = false;


// Hàm bấm số
private void numberButtonPressed(String number) {
    if (isResultDisplayed) {
        jtxtDisplay.setText("");  // Nếu vừa bấm = thì xóa màn hình
        isResultDisplayed = false;
    }
    jtxtDisplay.setText(jtxtDisplay.getText() + number);
}

// Hàm bấm toán tử (+, -, x, /)
private void operatorButtonPressed(String operator) {
    if (isResultDisplayed) {
        jtxtDisplay.setText(lastResult);  // Dùng kết quả cũ để tiếp tục tính
        isResultDisplayed = false;
    }
    jtxtDisplay.setText(jtxtDisplay.getText() + operator);
}

// Hàm bấm dấu bằng =
private void equalsButtonPressed() {
    try {
        String expression = jtxtDisplay.getText();
        // Đổi dấu cho đúng Java tính
        String evalExpr = expression.replace("x", "*").replace("÷", "/");
        // Tính kết quả
        double result = new ScriptEngineManager().getEngineByName("JavaScript").eval(evalExpr) instanceof Integer
            ? (Integer) new ScriptEngineManager().getEngineByName("JavaScript").eval(evalExpr)
            : (Double) new ScriptEngineManager().getEngineByName("JavaScript").eval(evalExpr);
        lastResult = String.valueOf(result);
        jtxtDisplay.setText(expression + "=" + lastResult);
        isResultDisplayed = true;
    } catch (Exception ex) {
        jtxtDisplay.setText("Error");
        isResultDisplayed = false;
    }
}
// Hàm bấm AC (Clear All)
private void clearButtonPressed() {
    jtxtDisplay.setText("");
    lastResult = "";
    isResultDisplayed = false;
}
private double eval(String expression) {
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    try {
        return Double.parseDouble(engine.eval(expression).toString());
    } catch (Exception e) {
        return 0;
    }
}

private String formatResult(BigDecimal result) {
   result = result.stripTrailingZeros(); // Bỏ số 0 dư thừa

    BigDecimal absResult = result.abs();
    if (absResult.compareTo(new BigDecimal("1E10")) > 0 || absResult.compareTo(new BigDecimal("1E-5")) < 0) {
        // Nếu rất lớn hoặc rất nhỏ thì hiện dạng khoa học (E)
        DecimalFormat df = new DecimalFormat("0.########E0");
        return df.format(result);
    } else {
        // Ngược lại thì hiện dạng bình thường, có phẩy ngăn cách
        DecimalFormat df = new DecimalFormat("#,##0.#####");
        return df.format(result);
}
}
private void applySingleMathFunction(String funcName, Function<Double, Double> function) {
    try {
        String number = jtxtDisplay.getText();

        if (isResultShown) {
            number = lastResult;
        }
        double value = Double.parseDouble(number);
        double result = function.apply(value);
        isResultDisplayed = true;

      String formattedResult = String.format("%.6f", result);
        String displayText = funcName + "(" + number + ") = " + formattedResult;    
        // Gán lại firstnum để tiếp tục phép toán
        firstnum = currentResult;
    // Lưu kết quả ra biến để tính tiếp
    lastResult = String.valueOf(result);
    firstnum = result; // Cập nhật firstnum là kết quả sau khi √
isResultShown = true;
         jtxtDisplay.setText(displayText);
        lastResult = String.valueOf(result);
        isResultShown = true;
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
}
private void appendNumber(String number) {
      String iNum = jtxtDisplay.getText();
    
    if (isResultShown) {
        iNum = "";            // Nếu vừa bấm = xong, xóa kết quả cũ
        isResultShown = false; // Reset lại trạng thái
    } 
        if (iNum.equals("0")) {
            iNum = number;
        } else {
            iNum += number;
        } 
    jtxtDisplay.setText(iNum);
}
    /**
     * Creates new form Scientific_Cal
     */
    public Scientific_Cal() {
        initComponents();
        setTitle("Calculator");     
        jtxtDisplay.setText("0");      
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlblResult = new javax.swing.JLabel();
        jtxtDisplay = new javax.swing.JTextField();
        jbtn7 = new javax.swing.JButton();
        jbtnAdd = new javax.swing.JButton();
        jbtn9 = new javax.swing.JButton();
        jbtn4 = new javax.swing.JButton();
        jbtn5 = new javax.swing.JButton();
        jbtn1 = new javax.swing.JButton();
        jbtnSub = new javax.swing.JButton();
        jbtn8 = new javax.swing.JButton();
        jbtn2 = new javax.swing.JButton();
        jbtn3 = new javax.swing.JButton();
        jbtnDiv = new javax.swing.JButton();
        jbtn6 = new javax.swing.JButton();
        jbtn0 = new javax.swing.JButton();
        jbtnPlusMinus = new javax.swing.JButton();
        jbtnEquals = new javax.swing.JButton();
        jbtnDot = new javax.swing.JButton();
        jbtnClear = new javax.swing.JButton();
        jbtnSqrt = new javax.swing.JButton();
        jbtnBackspace = new javax.swing.JButton();
        jbtnMult = new javax.swing.JButton();
        jbtnPi = new javax.swing.JButton();
        jbtnXY3 = new javax.swing.JButton();
        jbtnXY2 = new javax.swing.JButton();
        jbtnXY = new javax.swing.JButton();
        jbtnPercent = new javax.swing.JButton();
        jbtnCot = new javax.swing.JButton();
        jbtnSin = new javax.swing.JButton();
        jbtnTan = new javax.swing.JButton();
        jbtinCos = new javax.swing.JButton();
        jbtnLog = new javax.swing.JButton();
        jbtngiaithua = new javax.swing.JButton();
        jbtnLnx = new javax.swing.JButton();
        jbtnDegtoRad = new javax.swing.JButton();
        jbtnRadtoDeg = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jbtnHistory = new javax.swing.JMenuItem();

        jlblResult.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlblResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jtxtDisplay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jtxtDisplay.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jtxtDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDisplayActionPerformed(evt);
            }
        });
        jtxtDisplay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtDisplayKeyTyped(evt);
            }
        });

        jbtn7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn7.setText("7");
        jbtn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn7ActionPerformed(evt);
            }
        });

        jbtnAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnAdd.setText("+");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jbtn9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn9.setText("9");
        jbtn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn9ActionPerformed(evt);
            }
        });

        jbtn4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn4.setText("4");
        jbtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn4ActionPerformed(evt);
            }
        });

        jbtn5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn5.setText("5");
        jbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn5ActionPerformed(evt);
            }
        });

        jbtn1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn1.setText("1");
        jbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn1ActionPerformed(evt);
            }
        });

        jbtnSub.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSub.setText("-");
        jbtnSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSubActionPerformed(evt);
            }
        });

        jbtn8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn8.setText("8");
        jbtn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn8ActionPerformed(evt);
            }
        });

        jbtn2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn2.setText("2");
        jbtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn2ActionPerformed(evt);
            }
        });

        jbtn3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn3.setText("3");
        jbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn3ActionPerformed(evt);
            }
        });

        jbtnDiv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnDiv.setText("/");
        jbtnDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDivActionPerformed(evt);
            }
        });

        jbtn6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn6.setText("6");
        jbtn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn6ActionPerformed(evt);
            }
        });

        jbtn0.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtn0.setText("0");
        jbtn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn0ActionPerformed(evt);
            }
        });

        jbtnPlusMinus.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jbtnPlusMinus.setText("±");
        jbtnPlusMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPlusMinusActionPerformed(evt);
            }
        });

        jbtnEquals.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnEquals.setText("=");
        jbtnEquals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEqualsActionPerformed(evt);
            }
        });

        jbtnDot.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnDot.setText(".");
        jbtnDot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDotActionPerformed(evt);
            }
        });

        jbtnClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnClear.setText("C");
        jbtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClearActionPerformed(evt);
            }
        });

        jbtnSqrt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbtnSqrt.setText("√");
        jbtnSqrt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSqrtActionPerformed(evt);
            }
        });

        jbtnBackspace.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jbtnBackspace.setText("←");
        jbtnBackspace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBackspace(evt);
            }
        });

        jbtnMult.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnMult.setText("*");
        jbtnMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMultActionPerformed(evt);
            }
        });

        jbtnPi.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        jbtnPi.setText("π");
        jbtnPi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPiActionPerformed(evt);
            }
        });

        jbtnXY3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnXY3.setText("x^3");
        jbtnXY3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXY3ActionPerformed(evt);
            }
        });

        jbtnXY2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnXY2.setText("x^2");
        jbtnXY2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXY2ActionPerformed(evt);
            }
        });

        jbtnXY.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnXY.setText("x^y");
        jbtnXY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXYActionPerformed(evt);
            }
        });

        jbtnPercent.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnPercent.setText("%");
        jbtnPercent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnPercentActionPerformed(evt);
            }
        });

        jbtnCot.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnCot.setText("Cot");
        jbtnCot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCotActionPerformed(evt);
            }
        });

        jbtnSin.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnSin.setText("Sin");
        jbtnSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSinActionPerformed(evt);
            }
        });

        jbtnTan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnTan.setText("tan");
        jbtnTan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnTanActionPerformed(evt);
            }
        });

        jbtinCos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtinCos.setText("cos");
        jbtinCos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtinCosActionPerformed(evt);
            }
        });

        jbtnLog.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnLog.setText("log");
        jbtnLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLogActionPerformed(evt);
            }
        });

        jbtngiaithua.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtngiaithua.setText("n!");
        jbtngiaithua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtngiaithuaActionPerformed(evt);
            }
        });

        jbtnLnx.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jbtnLnx.setText("ln x");
        jbtnLnx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLnxActionPerformed(evt);
            }
        });

        jbtnDegtoRad.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jbtnDegtoRad.setText("Deg->Rad");
        jbtnDegtoRad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDegtoRadActionPerformed(evt);
            }
        });

        jbtnRadtoDeg.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jbtnRadtoDeg.setText("Rad->Deg");
        jbtnRadtoDeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnRadtoDegActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setText("Standard");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setText("Scientific");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jbtnHistory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jbtnHistory.setText("mniHistory");
        jbtnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHistoryActionPerformed(evt);
            }
        });
        jMenu2.add(jbtnHistory);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbtn0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtn7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtn4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtn1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnBackspace, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jbtnDot, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jbtn2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtn5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtn8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtn9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnSqrt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtn6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnPlusMinus, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jbtn3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                            .addComponent(jbtnSub, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnMult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnDiv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnEquals, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnXY3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnLog, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jbtnXY2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnPi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jbtnXY, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jbtnPercent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jbtnCot, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnSin, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(jbtnTan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jbtinCos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnDegtoRad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtngiaithua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnLnx, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnRadtoDeg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jtxtDisplay))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtxtDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jbtnSqrt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnClear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtnBackspace, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                            .addComponent(jbtnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtn7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtn8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtn9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnSub, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtn6, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtnMult, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnPercent, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnSin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtngiaithua, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbtnPi, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbtnTan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnLnx, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtnXY, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(jbtinCos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbtnDegtoRad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jbtnXY2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jbtnDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnCot, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnRadtoDeg, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtn0, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnDot, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnPlusMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnEquals, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jbtnLog, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnXY3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      this.setResizable(true);
    this.setSize(250, 380); // dùng setSize luôn cho chuẩn
this.revalidate();  
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn5ActionPerformed
         appendNumber(jbtn5.getText());            
    }//GEN-LAST:event_jbtn5ActionPerformed

    private void jbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn1ActionPerformed
        appendNumber(jbtn1.getText());             
    }//GEN-LAST:event_jbtn1ActionPerformed

    private void jbtnSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSubActionPerformed
try {
    String number = jtxtDisplay.getText().trim();

    if (number.contains("=")) {
        number = number.substring(number.indexOf("=") + 1).trim();
    }

    number = number.replace("(", "").replace(")", "");

    if (number.contains("+") || number.contains("-") || number.contains("*") || number.contains("/")) {
        number = number.substring(number.lastIndexOf(' ') + 1);
    }

    double value = Double.parseDouble(number);

    firstnum = value;
    operations = "-";
    jtxtDisplay.setText(number + " - ");
    isResultShown = false;

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jbtnSubActionPerformed

    private void jbtn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn8ActionPerformed
      appendNumber(jbtn8.getText());       
    }//GEN-LAST:event_jbtn8ActionPerformed

    private void jbtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn4ActionPerformed
      appendNumber(jbtn4.getText());    
    }//GEN-LAST:event_jbtn4ActionPerformed

    private void jbtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn2ActionPerformed
        appendNumber(jbtn2.getText());        
    }//GEN-LAST:event_jbtn2ActionPerformed

    private void jbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn3ActionPerformed
      appendNumber(jbtn3.getText());   
    }//GEN-LAST:event_jbtn3ActionPerformed

    private void jbtnDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDivActionPerformed
    try {
    String number = jtxtDisplay.getText().trim();

    if (number.contains("=")) {
        number = number.substring(number.indexOf("=") + 1).trim();
    }

    number = number.replace("(", "").replace(")", "");

    if (number.contains("+") || number.contains("-") || number.contains("*") || number.contains("/")) {
        number = number.substring(number.lastIndexOf(' ') + 1);
    }

    double value = Double.parseDouble(number);

    firstnum = value;
    operations = "/";
    jtxtDisplay.setText(number + " / ");
    isResultShown = false;

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_jbtnDivActionPerformed

    private void jbtn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn6ActionPerformed
        appendNumber(jbtn6.getText());       
    }//GEN-LAST:event_jbtn6ActionPerformed

    private void jbtn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn0ActionPerformed
    appendNumber(jbtn0.getText());
       
    }//GEN-LAST:event_jbtn0ActionPerformed

    private void jbtnPlusMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPlusMinusActionPerformed
    String text = jtxtDisplay.getText();
if (text.isEmpty()) {
    JOptionPane.showMessageDialog(this, "Vui lòng nhập số trước!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    return;
}
try {
    int lastOperator = Math.max(
        Math.max(text.lastIndexOf('+'), text.lastIndexOf('-')),
        Math.max(text.lastIndexOf('*'), text.lastIndexOf('/'))
    );

    String before = "";
    String number = text;
    if (lastOperator != -1) {
        before = text.substring(0, lastOperator + 1);
        number = text.substring(lastOperator + 1);
    }

    if (number.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập số trước!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // 👉 Bỏ dấu ngoặc nếu có
    number = number.replace("(", "").replace(")", "");
    double value = Double.parseDouble(number);

    // 👉 Đổi dấu
    value = value * (-1);

    // 👉 Chuyển lại thành chuỗi, không thêm ngoặc nếu không cần thiết
    String valueStr = Double.toString(value);
    jtxtDisplay.setText(before + valueStr);

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_jbtnPlusMinusActionPerformed

    private void jbtnEqualsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEqualsActionPerformed
                                    
String answer;
BigDecimal result;
BigDecimal secondnum;
if (jtxtDisplay.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Vui lòng nhập số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    return;
}
try {
    String inputText = jtxtDisplay.getText().trim();
    String inputForCalculation = inputText.replace("(", "").replace(")", "");
    if (inputText.startsWith("Nhập y:")) {
        inputForCalculation = inputForCalculation.replace("Nhập y:", "").trim();
        if (inputForCalculation.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số mũ y!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        BigDecimal y = new BigDecimal(inputForCalculation);
        // BigDecimal không hỗ trợ pow(double), nên dùng Math.pow
        result = BigDecimal.valueOf(Math.pow(giaTriX, y.doubleValue()));
        answer = formatResult(result);
        jtxtDisplay.setText("Nhập y: " + y.toPlainString() + " = " + answer);
        giaTriX = 0;
        operations = "";
        isResultShown = true;
        return;
    }
    if (operations.isEmpty()) {
        // Không có phép toán lưu sẵn -> tự động tính cả biểu thức
        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            Object evalResult = engine.eval(inputForCalculation);
            result = new BigDecimal(evalResult.toString());
            answer = formatResult(result);
            jtxtDisplay.setText(inputText + " = " + answer);
            firstnum = result.doubleValue();
            operations = "";
            isResultShown = true;

            lichSuTinhToan += inputText + " = " + answer + "\n";
            System.out.println(lichSuTinhToan);

        } catch (ScriptException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi trong biểu thức!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return;
    }
    // Nếu có phép toán đang lưu (ví dụ bấm 5 + 3 rồi bấm =)
    int opIndex = inputForCalculation.indexOf(operations);
    if (opIndex == -1) {
        JOptionPane.showMessageDialog(this, "Không tìm thấy phép toán!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    String secondNumberText = inputForCalculation.substring(opIndex + 1).trim();
    if (secondNumberText.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập số thứ hai!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }
    secondnum = new BigDecimal(secondNumberText);

    BigDecimal firstnumBD = BigDecimal.valueOf(firstnum);
    switch (operations) {
        case "+":
            result = firstnumBD.add(secondnum);
            break;
        case "-":
            result = firstnumBD.subtract(secondnum);
            break;
        case "*":
            result = firstnumBD.multiply(secondnum);
            break;
        case "/":
            if (secondnum.compareTo(BigDecimal.ZERO) == 0) {
                jtxtDisplay.setText("Lỗi chia cho 0");
                return;
            }
            result = firstnumBD.divide(secondnum, MathContext.DECIMAL128);
            break;
        case "%":
            if (secondnum.compareTo(BigDecimal.ZERO) == 0) {
                jtxtDisplay.setText("Lỗi chia cho 0");
                return;
            }
            result = firstnumBD.remainder(secondnum);
            break;
        default:
            JOptionPane.showMessageDialog(this, "Phép tính không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
    }
    answer = formatResult(result);
    jtxtDisplay.setText(inputText + " = " + answer);

    firstnum = result.doubleValue();
    operations = "";
    isResultShown = true;
    lichSuTinhToan += inputText + " = " + answer + "\n";
    System.out.println(lichSuTinhToan);

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jbtnEqualsActionPerformed
    }
    private void jbtnDotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDotActionPerformed
         // dấu phẩy
    String text = jtxtDisplay.getText();

    if (text.isEmpty()) {
        // Nếu chưa nhập số mà bấm dấu ., báo lỗi
        JOptionPane.showMessageDialog(this, "Bạn phải nhập số trước!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
    } else if (!text.contains(".")) {
        jtxtDisplay.setText(text + jbtnDot.getText());
    }
    }//GEN-LAST:event_jbtnDotActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        this.setResizable(true);
   
        
    }//GEN-LAST:event_formWindowActivated

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setResizable(true);
    this.setSize(521, 380); // Kích thước to ra để chứa thêm nút chức năng khoa học
    jtxtDisplay.setSize(484, 39); // Ô text input kéo dài cho phù hợp
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jbtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClearActionPerformed
        //xoa
        jtxtDisplay.setText("");
    }//GEN-LAST:event_jbtnClearActionPerformed

    private void jbtnSqrtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSqrtActionPerformed
                                          
    try {
        String text = jtxtDisplay.getText();
    String[] parts = text.split("="); // lấy phần sau dấu "=" nếu có
    String lastPart = parts.length > 1 ? parts[1].trim() : text.trim();
    double ops = Double.parseDouble(lastPart); // chuyển sang double

        if (ops < 0) {
            JOptionPane.showMessageDialog(this, "Không thể lấy căn số âm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double result = Math.sqrt(ops);
        DecimalFormat df = new DecimalFormat("0.##########");
        df.setMaximumFractionDigits(10);
df.setGroupingUsed(false); // Tắt dấu phẩy phân nhóm 1,000
df.setMaximumIntegerDigits(100); // Để số nguyên lớn cũng không bị dạng E
String formattedResultFixed = df.format(result); 

    // Định dạng kết quả cho đẹp
    String formattedOps = (ops % 1 == 0) ? String.format("%.0f", ops) : String.valueOf(ops);
    String formattedResult = (result % 1 == 0) ? String.format("%.0f", result) : String.valueOf(result);

    // Lưu kết quả ra biến để tính tiếp
        lastResult = String.valueOf(result);
    firstnum = result; // Cập nhật firstnum là kết quả sau khi √
isResultShown = true;

    // Hiển thị phép tính và kết quả
  // Hiển thị lên màn hình
jtxtDisplay.setText("√(" + formattedOps + ") = " + formattedResultFixed);
lichSuTinhToan += "√(" + formattedOps + ") = " + formattedResultFixed + "\n";


} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jbtnSqrtActionPerformed

    private void jbtnBackspace(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBackspace
        String bsp=null;
        if(jtxtDisplay.getText().length()>0)
        {
            StringBuilder strB =new StringBuilder(jtxtDisplay.getText());
            strB.deleteCharAt(jtxtDisplay.getText().length()-1);
            bsp=strB.toString();
            jtxtDisplay.setText(bsp);             
                 
        }
    }//GEN-LAST:event_jbtnBackspace

    private void jbtnMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMultActionPerformed
     try {
    String number = jtxtDisplay.getText().trim();

    if (number.contains("=")) {
        number = number.substring(number.indexOf("=") + 1).trim();
    }

    number = number.replace("(", "").replace(")", "");

    if (number.contains("+") || number.contains("-") || number.contains("*") || number.contains("/")) {
        number = number.substring(number.lastIndexOf(' ') + 1);
    }

    double value = Double.parseDouble(number);

    firstnum = value;
    operations = "*";
    jtxtDisplay.setText(number + " * ");
    isResultShown = false;

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_jbtnMultActionPerformed

    private void jbtnXY3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXY3ActionPerformed
  if (jtxtDisplay.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Vui lòng nhập số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    return;
}

try {
    double ops = Double.parseDouble(jtxtDisplay.getText());
    double result = ops * ops * ops;

    // Định dạng số nếu cần
    String formattedOps = (ops % 1 == 0) ? String.format("%.0f", ops) : String.valueOf(ops);
    String formattedResult = (result % 1 == 0) ? String.format("%.0f", result) : String.format("%.2f", result);

    // Hiển thị phép toán và kết quả
    jtxtDisplay.setText(formattedOps + "³ = " + formattedResult);

    // **Lưu lịch sử**
    lichSuTinhToan += formattedOps + "³ = " + formattedResult + "\n";

    System.out.println(lichSuTinhToan); // Debug kiểm tra lịch sử
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jbtnXY3ActionPerformed

    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
 
 try {
    String number = jtxtDisplay.getText().trim();

    // Nếu vừa bấm "=" xong => lấy kết quả sau dấu "="
    if (number.contains("=")) {
        number = number.substring(number.indexOf("=") + 1).trim();
    }

    // Bỏ dấu ngoặc nếu có
    number = number.replace("(", "").replace(")", "");

    // Tránh cắt nhầm nếu trước đó đã có phép tính
    if (number.contains("+") || number.contains("-") || number.contains("*") || number.contains("/")) {
        number = number.substring(number.lastIndexOf(' ') + 1);
    }

    double value = Double.parseDouble(number);

    // Gán giá trị để tiếp tục phép toán
    firstnum = value;
    operations = "+";
    jtxtDisplay.setText(number + " + ");
    isResultShown = false; // Cho biết đang thực hiện tiếp, chưa ra kết quả

} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_jbtnAddActionPerformed

    private void jbtnXY2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXY2ActionPerformed
       if (jtxtDisplay.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Vui lòng nhập số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    return;
}

try {
    double ops = Double.parseDouble(jtxtDisplay.getText());
    double result = ops * ops;

    // Định dạng số nếu cần
    String formattedOps = (ops % 1 == 0) ? String.format("%.0f", ops) : String.valueOf(ops);
    String formattedResult = (result % 1 == 0) ? String.format("%.0f", result) : String.format("%.2f", result);
        
    // Hiển thị phép toán và kết quả
    jtxtDisplay.setText(formattedOps + "² = " + formattedResult);

    // **Lưu lịch sử**  
    lichSuTinhToan += formattedOps + "² = " + formattedResult + "\n";  

    System.out.println(lichSuTinhToan); // Debug kiểm tra lịch sử
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_jbtnXY2ActionPerformed

    private void jbtnXYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXYActionPerformed
        try {  
    // Lấy giá trị x từ ô hiển thị  
    double x = Double.parseDouble(jtxtDisplay.getText());  

    // Gán lại ô hiển thị cho y  
    jtxtDisplay.setText("Nhập y:");  

    // Dùng hộp thoại để nhập giá trị y từ người dùng  
    String yStr = JOptionPane.showInputDialog("Nhập y:");  
    double y = Double.parseDouble(yStr);  

    // Tính toán x^y  
    double result = Math.pow(x, y);  
    jtxtDisplay.setText(x + " ^ " + y + " = " + result);  

    // **Lưu lịch sử**  
    lichSuTinhToan += x + " ^ " + y + " = " + result + "\n";  

    System.out.println(lichSuTinhToan); // Debug kiểm tra lịch sử
} catch (NumberFormatException e) {  
    jtxtDisplay.setText("Dữ liệu không hợp lệ");  
}
    }//GEN-LAST:event_jbtnXYActionPerformed

    private void jbtn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn7ActionPerformed
        appendNumber(jbtn7.getText());           
    }//GEN-LAST:event_jbtn7ActionPerformed

    private void jbtn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn9ActionPerformed
  appendNumber(jbtn9.getText());
    }//GEN-LAST:event_jbtn9ActionPerformed

    private void jbtnPiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPiActionPerformed
  String input = jtxtDisplay.getText().trim();

    if (input.isEmpty()) {
        input = "1"; // Nếu trống thì coi như 1
    }
    try {
        double value = Double.parseDouble(input);
        double result = value * Math.PI;
        currentResult = result;
        jtxtDisplay.setText("" + result);
        // Gán lại firstnum để tiếp tục phép toán
        firstnum = currentResult;

    // Lưu kết quả ra biến để tính tiếp
    lastResult = String.valueOf(result);
    firstnum = result; // Cập nhật firstnum là kết quả sau khi √
isResultShown = true;      
jtxtDisplay.setText(  input+"π" + " = " + result);

        lichSuTinhToan += input + "π = " + result + "\n";
    } catch (Exception e) {
        jtxtDisplay.setText("Error");
        JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jbtnPiActionPerformed

    private void jtxtDisplayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtDisplayKeyTyped
        char c = evt.getKeyChar();
    System.out.println("Key Pressed: " + c); // Debug xem có nhận đúng không

   if (!(Character.isDigit(c) || c == '.' || c == '-' 
        || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) { 
         getToolkit().beep();  
        evt.consume(); 
        System.out.println("Beep triggered!"); 

        //dùng để chặn nhâp kí tự không phải số,trừ phím backspace và Delete. Nếu nhập sai ,phát âm thanh cảnh báo beep()
   }
    }//GEN-LAST:event_jtxtDisplayKeyTyped

    private void jtxtDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDisplayActionPerformed
      // Gán DocumentListener cho jtxtMainDisplay
 jtxtDisplay.getDocument().addDocumentListener(new DocumentListener() { 
    public void insertUpdate(DocumentEvent e) {
        updateResult();    
        
    }
    @Override
    public void removeUpdate(DocumentEvent e) {
        updateResult();
    }
    @Override
    public void changedUpdate(DocumentEvent e) {
        updateResult();
    }
           private void updateResult() {
               throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
           }
       });

    }//GEN-LAST:event_jtxtDisplayActionPerformed

    private void jbtnPercentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnPercentActionPerformed
try {
    String input = jtxtDisplay.getText().trim();

    if (input.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Nếu có dấu "=" thì chỉ lấy phần sau
    String[] partsEqual = input.split("=");
    String lastPart = partsEqual.length > 1 ? partsEqual[1].trim() : input;

    // Bỏ ngoặc nếu nhập dạng (-9)
    if (lastPart.startsWith("(") && lastPart.endsWith(")")) {
        lastPart = lastPart.substring(1, lastPart.length() - 1);
    }

    // Kiểm tra biểu thức có phải phép toán (phải chứa 2 toán hạng và 1 toán tử)
    String operatorRegex = "(?<!^)[+\\-*/](?!$)"; // toán tử không ở đầu/cuối
    String[] parts = lastPart.split(operatorRegex);

    if (parts.length == 2) {
        double num1 = Double.parseDouble(parts[0].trim());
        double num2 = Double.parseDouble(parts[1].trim());

        // Tìm toán tử thực sự (bỏ số và dấu .)
        char operator = lastPart.replaceAll("[0-9.()]", "").charAt(0);

        double percentValue = num1 * (num2 / 100);
        double result = 0;

        switch (operator) {
            case '+': result = num1 + percentValue; break;
            case '-': result = num1 - percentValue; break;
            case '*': result = percentValue; break;
            case '/': result = num1 / (num2 / 100); break;
        }

        jtxtDisplay.setText(lastPart + " = " + result);
        lichSuTinhToan += lastPart + " = " + result + "\n";
        System.out.println(lichSuTinhToan);
    } else {
        // Trường hợp chỉ có 1 số, có thể là âm
        double value = Double.parseDouble(lastPart) / 100;
        jtxtDisplay.setText(lastPart + "% = " + value);

        lichSuTinhToan += lastPart + "% = " + value + "\n";
        System.out.println(lichSuTinhToan);
    }

} catch (Exception ex) {
    jtxtDisplay.setText("Error");
    JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
}

         
    }//GEN-LAST:event_jbtnPercentActionPerformed

    private void jbtnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHistoryActionPerformed
       HistoryDialog historyDialog = new HistoryDialog(this, true);
    historyDialog.setHistory(lichSuTinhToan); 
    historyDialog.setVisible(true);
    }//GEN-LAST:event_jbtnHistoryActionPerformed

    private void jbtnCotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCotActionPerformed
    applySingleMathFunction("cot", x -> {
        double tanValue = Math.tan(Math.toRadians(x));
        if (Math.abs(tanValue) < 1E-10) return Double.POSITIVE_INFINITY; 
        return 1 / tanValue;
    });
  String input = jtxtDisplay.getText();
       BigDecimal bdResult = new BigDecimal(result);
        String formatResult = formatResult(bdResult);
     lichSuTinhToan += "sin(" + input + ") = " + formatResult + "\n";


    }//GEN-LAST:event_jbtnCotActionPerformed

    private void jbtnSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSinActionPerformed
                                        
    applySingleMathFunction("sin", x -> Math.sin(Math.toRadians(x)));
     String input = jtxtDisplay.getText();
       BigDecimal bdResult = new BigDecimal(result);
        String formatResult = formatResult(bdResult);
     lichSuTinhToan += "sin(" + input + ") = " + formatResult + "\n";


    }//GEN-LAST:event_jbtnSinActionPerformed

    private void jbtinCosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtinCosActionPerformed
        applySingleMathFunction("cos", x -> Math.cos(Math.toRadians(x)));
        String input = jtxtDisplay.getText();
       BigDecimal bdResult = new BigDecimal(result);
        String formatResult = formatResult(bdResult);
     lichSuTinhToan += "sin(" + input + ") = " + formatResult + "\n";
    }//GEN-LAST:event_jbtinCosActionPerformed

    private void jbtnTanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnTanActionPerformed
          applySingleMathFunction("tan", x -> Math.tan(Math.toRadians(x)));
          String input = jtxtDisplay.getText();
       BigDecimal bdResult = new BigDecimal(result);
        String formatResult = formatResult(bdResult);
     lichSuTinhToan += "sin(" + input + ") = " + formatResult + "\n";
    }//GEN-LAST:event_jbtnTanActionPerformed

    private void jbtnLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLogActionPerformed
        applySingleMathFunction("log", x -> Math.log10(x));
        String input = jtxtDisplay.getText();
       BigDecimal bdResult = new BigDecimal(result);
        String formatResult = formatResult(bdResult);
     lichSuTinhToan += "sin(" + input + ") = " + formatResult + "\n";
    }//GEN-LAST:event_jbtnLogActionPerformed

    private void jbtngiaithuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtngiaithuaActionPerformed
  String input = jtxtDisplay.getText();
try {
    int n = Integer.parseInt(input);
    if (n < 0) {
        JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    BigInteger result = BigInteger.ONE;
    for (int i = 2; i <= n; i++) {
        result = result.multiply(BigInteger.valueOf(i));
    }

    // Hiển thị kết quả gọn gàng
    String resultText;
    BigDecimal bigDecimalResult = new BigDecimal(result);
    boolean isTooBig = false;

    try {
        double resultDouble = bigDecimalResult.doubleValue();
        if (Double.isInfinite(resultDouble)) {
            isTooBig = true;
        }
    } catch (Exception e) {
        isTooBig = true;
    }

    if (isTooBig || result.toString().length() > 15) {
        DecimalFormat sciFormat = new DecimalFormat("0.#####E0");
        resultText = sciFormat.format(bigDecimalResult);
    } else {
        resultText = result.toString();
    }

    jtxtDisplay.setText(input + "! = " + resultText);
    lichSuTinhToan += input + "! = " + resultText + "\n";

    try {
        firstnum = Double.parseDouble(resultText);
        isBigNumber = false;
    } catch (NumberFormatException ex) {
        firstBigNum = bigDecimalResult;
        isBigNumber = true;
    }

    isResultShown = true;

} catch (NumberFormatException ex) {
    JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    jtxtDisplay.setText("Error");
}

    }//GEN-LAST:event_jbtngiaithuaActionPerformed

    private void jbtnLnxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLnxActionPerformed
        try {
        String input = jtxtDisplay.getText().trim();

        // Xử lý trường hợp người dùng nhập ln(...) hoặc chứa ký tự đặc biệt
        input = input.replace("ln", "").replace("(", "").replace(")", "").trim();

        double value = Double.parseDouble(input);

        if (value <= 0) {
            JOptionPane.showMessageDialog(this, "Giá trị phải lớn hơn 0 để tính ln(x)", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double result = Math.log(value);

        // Hiển thị kết quả
        jtxtDisplay.setText("ln(" + value + ") = " + result);

        // Ghi lịch sử nếu bạn có dùng biến lichSuTinhToan
        lichSuTinhToan += "ln(" + value + ") = " + result + "\n";

        // Lưu kết quả để dùng tiếp trong phép toán
        firstnum = result;
        isResultShown = true;
        isBigNumber = false;

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        jtxtDisplay.setText("Error");
    }

    }//GEN-LAST:event_jbtnLnxActionPerformed

    private void jbtnDegtoRadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDegtoRadActionPerformed

    try {
        String input = jtxtDisplay.getText().trim();

        // Xử lý nếu nhập dưới dạng (-9)
        if (input.startsWith("(") && input.endsWith(")")) {
            input = input.substring(1, input.length() - 1); // Bỏ dấu ngoặc
        }

        // Bỏ ký tự "°" nếu có và xóa khoảng trắng
        input = input.replace("°", "").trim();

        // Chuyển đổi từ chuỗi sang số thực
        double degrees = Double.parseDouble(input);

        // Chuyển từ độ sang radian
        double radians = Math.toRadians(degrees);

        // Hiển thị kết quả
        jtxtDisplay.setText(degrees + "° = " + radians + " rad");

        // Ghi vào lịch sử nếu cần
        lichSuTinhToan += degrees + "° = " + radians + " rad\n";

        // Lưu kết quả để tiếp tục phép tính
        firstnum = radians;
        isResultShown = true;
        isBigNumber = false;

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        jtxtDisplay.setText("Error");
    }
    }//GEN-LAST:event_jbtnDegtoRadActionPerformed

    private void jbtnRadtoDegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnRadtoDegActionPerformed
      try {
        String input = jtxtDisplay.getText().trim();

        // Xử lý nếu nhập dưới dạng (-x)
        if (input.startsWith("(") && input.endsWith(")")) {
            input = input.substring(1, input.length() - 1); // Bỏ dấu ngoặc
        }

        input = input.replace("rad", "").trim(); // Bỏ đơn vị rad nếu có

        // Chuyển input thành số thực
        double radians = Double.parseDouble(input);

        // Đổi sang độ
        double degrees = Math.toDegrees(radians);

        // Hiển thị kết quả
        jtxtDisplay.setText(radians + " rad = " + degrees + "°");

        // Ghi vào lịch sử nếu có
        lichSuTinhToan += radians + " rad = " + degrees + "°\n";

        // Lưu kết quả để tính tiếp nếu cần
        firstnum = degrees;
        isResultShown = true;
        isBigNumber = false;

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Dữ liệu không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        jtxtDisplay.setText("Error");
    }

    }//GEN-LAST:event_jbtnRadtoDegActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Scientific_Cal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scientific_Cal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scientific_Cal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scientific_Cal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scientific_Cal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JButton jbtinCos;
    private javax.swing.JButton jbtn0;
    private javax.swing.JButton jbtn1;
    private javax.swing.JButton jbtn2;
    private javax.swing.JButton jbtn3;
    private javax.swing.JButton jbtn4;
    private javax.swing.JButton jbtn5;
    private javax.swing.JButton jbtn6;
    private javax.swing.JButton jbtn7;
    private javax.swing.JButton jbtn8;
    private javax.swing.JButton jbtn9;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnBackspace;
    private javax.swing.JButton jbtnClear;
    private javax.swing.JButton jbtnCot;
    private javax.swing.JButton jbtnDegtoRad;
    private javax.swing.JButton jbtnDiv;
    private javax.swing.JButton jbtnDot;
    private javax.swing.JButton jbtnEquals;
    private javax.swing.JMenuItem jbtnHistory;
    private javax.swing.JButton jbtnLnx;
    private javax.swing.JButton jbtnLog;
    private javax.swing.JButton jbtnMult;
    private javax.swing.JButton jbtnPercent;
    private javax.swing.JButton jbtnPi;
    private javax.swing.JButton jbtnPlusMinus;
    private javax.swing.JButton jbtnRadtoDeg;
    private javax.swing.JButton jbtnSin;
    private javax.swing.JButton jbtnSqrt;
    private javax.swing.JButton jbtnSub;
    private javax.swing.JButton jbtnTan;
    private javax.swing.JButton jbtnXY;
    private javax.swing.JButton jbtnXY2;
    private javax.swing.JButton jbtnXY3;
    private javax.swing.JButton jbtngiaithua;
    private javax.swing.JLabel jlblResult;
    private javax.swing.JTextField jtxtDisplay;
    // End of variables declaration//GEN-END:variables

    private void operations(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void updateResult() {
     String expression = jtxtDisplay.getText().trim(); // Lấy biểu thức và loại bỏ khoảng trắng

   if (expression.isEmpty() || !Character.isDigit(expression.charAt(expression.length() - 1))) {
        // Kiểm tra nếu biểu thức rỗng hoặc kết thúc bằng toán tử thì không thực hiện
        return;
    }

    try {
        // Dùng ScriptEngine để tính toán
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        Object ketQua = engine.eval(expression); // Thực hiện phép toán

        // Hiển thị kết quả ngay trong jtxtDisplay
        jtxtDisplay.setText(expression + " = " + ketQua);

    } catch (Exception e) {
        jtxtDisplay.setText("Lỗi!");
    }
}

   private double evaluate(String expression) {
    try {
        // Dùng ScriptEngine để tính toán biểu thức toán học
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        return Double.parseDouble(engine.eval(expression).toString());
    } catch (Exception e) {
        return Double.NaN; // Trả về NaN nếu có lỗi
    }
}
}
