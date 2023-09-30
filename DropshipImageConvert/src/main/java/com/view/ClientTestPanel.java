/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.api.dropship.DropApiCall;
import com.config.Configs;
import static com.config.Configs.CACHE_PATH;
import static com.config.Configs.COOKIE_PATH;
import com.interfaces.ActionListener;
import com.interfaces.CrawlProcessListener;
import com.controller.MainController;
import com.models.aliex.store.BaseStoreInfo;
import com.models.aliex.store.inputdata.BaseStoreOrderInfo;
import com.models.aliex.store.inputdata.SnakeBaseStoreOrderInfo;
import com.controller.thread.SendInfoThread;
import com.controller.TestController;
import com.interfaces.DownloadListener;
import com.controller.DownloadManager;
import com.controller.crawl.aliex.AliexCrawlSvs;
import com.controller.inputprocess.SnakeReadOrderInfoSvs;
import com.models.response.ResponseObj;
import com.utils.Constants;
import com.utils.CookieUtil;
import com.utils.DialogUtil;
import com.utils.PhantomJsManager;
import com.utils.StringUtils;
import com.utils.WindowsShortcut;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumn;

/**
 *
 * @author Admin
 */
public class ClientTestPanel extends BasePanel {

    JFrame topFrame;
    JFileChooser chooser;
    String choosertitle;

    ArrayList<BaseStoreInfo> listStorePage = new ArrayList<>();

    TestController testController;

    JPanel controls;

//    ProcessPannel processPannel;
    public ClientTestPanel() {
        initComponents();
        setupTableUI();
        setTitle("DropshipToolsTest");
        setMenuActionCommand("MainHomeTest");
        initData();

    }

    public void setupTableUI() {
        TableColumn column = null;
        for (int i = 0; i < 2; i++) {
            column = jTableResult.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setMaxWidth(230);
            } else {
                column.setMaxWidth(120);
            }

        }
    }

    public void initData() {

        testController = new TestController();

        topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

//        String pathStr = null;
//        if (OSUtil.isWindows()) {
//            pathStr = Configs.CONFIG_FOLDER_PATH + "chromedriver.exe";
//        } else {
//            pathStr = Configs.CONFIG_FOLDER_PATH + "chromedriver";
//        }
//
//        if (pathStr != null) {
//            System.setProperty("webdriver.chrome.driver", pathStr);
//        }
//        txtProfilePath.setText("" + Configs.profilePath);

        btnStop.setEnabled(false);
        DownloadManager.getInstance().setListener(downloadListener);
        updateDownloadState();

//        if (!AliexCrawlSvs.getInstance().isHasCookies()) {
//            AliexCrawlSvs.getInstance().autoLoginAliex();
//        }
//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                processPannel = new ProcessPannel(statePannel.getWidth(), statePannel.getHeight());
//                processPannel.setBackground(Color.red);
//                statePannel.add(processPannel);
//                statePannel.validate();
//            }
//        });
    }
    
    public void stopThread() {
    }

    public void disableButton() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        txtStoreFilePath = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        statePannel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResult = new javax.swing.JTable();
        txtProfilePath = new javax.swing.JTextField();
        btnBrowseProfile = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnStartCrawl = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        btnLoadProfile = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblDownloadState = new javax.swing.JLabel();
        jTextFieldLanguage = new javax.swing.JTextField();
        jButtonSaveCookies = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel3.setFocusTraversalPolicyProvider(true);

        txtStoreFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStoreFilePathActionPerformed(evt);
            }
        });

        jLabel2.setText("States");

        jLabel1.setText("Product Url");

        jTableResult.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTableResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "AccNo", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableResult.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableResult.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableResult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableResultMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableResult);

        javax.swing.GroupLayout statePannelLayout = new javax.swing.GroupLayout(statePannel);
        statePannel.setLayout(statePannelLayout);
        statePannelLayout.setHorizontalGroup(
            statePannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
            .addGroup(statePannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statePannelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        statePannelLayout.setVerticalGroup(
            statePannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(statePannelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(statePannelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnBrowseProfile.setText("Browse...");
        btnBrowseProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseProfileActionPerformed(evt);
            }
        });

        jLabel3.setText("Profile Path");

        btnStartCrawl.setText("Start");
        btnStartCrawl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartCrawlActionPerformed(evt);
            }
        });

        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        btnLoadProfile.setText("Load Profile");
        btnLoadProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadProfileActionPerformed(evt);
            }
        });

        jLabel4.setText("Download Image: ");

        jTextFieldLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldLanguageActionPerformed(evt);
            }
        });

        jButtonSaveCookies.setText("Save Cookie");
        jButtonSaveCookies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveCookiesActionPerformed(evt);
            }
        });

        jButton1.setText("LoadPage");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4))
                                    .addComponent(txtProfilePath, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtStoreFilePath, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnBrowseProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblDownloadState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(statePannel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jTextFieldLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonSaveCookies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnLoadProfile)
                        .addGap(26, 26, 26)
                        .addComponent(btnStartCrawl, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStop)
                    .addComponent(btnStartCrawl)
                    .addComponent(btnLoadProfile))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProfilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBrowseProfile))
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtStoreFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDownloadState, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveCookies))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(13, 13, 13)
                .addComponent(statePannel, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    BaseStoreInfo storePageInfo;

    public void browsePage() {

    }

    public void loadStore(BaseStoreInfo storePageInfo) {

    }

    public void startCrawl() {
        testController.setProductUrl(txtStoreFilePath.getText());
    }

    public long lastLoad;
//    public int pageCount;

    public void nextPage() {

    }

    public void stopCrawl() {
//        aliexCrawlThread.stopCrawl();
    }
    
    public void closeApp() {
        AliexCrawlSvs.getInstance().close();
    }

    private void txtStoreFilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStoreFilePathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStoreFilePathActionPerformed

    private void btnStartCrawlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartCrawlActionPerformed

        if (txtStoreFilePath.getText().isEmpty()) {
            DialogUtil.showErrorMessage(topFrame, "", "Please input a product url!");
            return;
        }
        
        if (!Configs.isClickedLoadProfile) {
            DialogUtil.showErrorMessage(topFrame, "", "Bạn cần load profile và đăng nhập vào aliexpress trước khi start!");
            return;
        }

//        ResponseObj responseObj = DropApiCall.doSendGetInfo(null);

//        if (responseObj == null) {
//            System.out.println("Can not check info!");
//            return;
//        }

//        switch (responseObj.getResultCode()) {
//            case Constants.ResultCode.SERIAL_INVALID:
//                DialogUtil.showInfoMessage(null, "Máy tính cài đặt không hợp lệ. Liên hệ 0972071089 để được xác thực!");
//                return;
//            case Constants.ResultCode.VERSION_INVALID:
//                DialogUtil.showInfoMessage(null, responseObj.getMessage() != null ? responseObj.getMessage() : "Version app không hợp lệ!");
//                return;
//        }
//        if (responseObj.getMessage() != null) {
//            DialogUtil.showInfoMessage(null, responseObj.getMessage());
//        }

//        CookieUtil.deleteCookies();
        if (!AliexCrawlSvs.getInstance().rechiveCookies()) {
            DialogUtil.showInfoMessage(null, "Vui lòng thực hiện đăng nhập Aliexpress trước khi bắt đầu!");
            return;
        }

        updateDownloadState();
        PhantomJsManager.getInstance().init();
        testController.setProductUrl(txtStoreFilePath.getText());
        testController.setCookieType(jTextFieldLanguage.getText());
        testController.startCrawl();
    }//GEN-LAST:event_btnStartCrawlActionPerformed

    DownloadListener downloadListener = new DownloadListener() {
        @Override
        public void onComplete(String key) {
            updateDownloadState();
        }
    };
    
    public void updateDownloadState() {
        if (StringUtils.isEmpty(Configs.vpsIp)) {
            lblDownloadState.setText("");
        } else {
            lblDownloadState.setText("" + DownloadManager.getInstance().getTotalComplete() + "/" + DownloadManager.getInstance().getTotalDownload());
        }
        
    }
    
    public void updateTable() {
        jTableResult.removeAll();
        jTableResult.setModel(new StoreStateTableModel());
        setupTableUI();
    }

    CrawlProcessListener crawlProcessListener = new CrawlProcessListener() {

        @Override
        public void onPushState(String storeSign, String state) {
            DataUtils.updateStatus(storeSign, state);
            updateTable();
        }

        @Override
        public void onStop(String storeSign) {
//            mainController.stopCrawl();
        }

        @Override
        public void onStartProcess(String storeSign, String accNo) {
//            ProcessState processState = ProcessState.createInstance(storeSign, accNo);
//            processPannel.addData(processState);
        }

        @Override
        public void onStopToLogin(String currentUrl, String storeSign) {
//            processPannel.updateStatus(storeSign, "Need to login...");
//            CookieUtil.deleteCookies();

//            LoginThread loginThread = new LoginThread(true, currentUrl);
//            loginThread.start();
            AliexCrawlSvs.getInstance().goToLogin(currentUrl);

            DialogUtil.showInfoMessage(null, "Vui lòng thực hiện đăng nhập lại sau đó ấn Resume!");
        }

        @Override
        public void onFinishPage(String storeSign) {
           
        }

        @Override
        public void onPushErrorRequest(String storeSign, ResponseObj responseObj) {
            DialogUtil.showErrorMessage(topFrame, "", responseObj.getMessage());
        }

    };

    ActionListener actionListener = new ActionListener() {
        @Override
        public void onFinish(MainController.STATE state) {
            switch (state) {
                case STOP:
                    btnStartCrawl.setText("Start");
                    btnStop.setEnabled(false);
                    break;
                case RUNNING:
                    btnStartCrawl.setText("Pause");
                    btnStop.setEnabled(true);
                    break;
                case PAUSING:
                    btnStartCrawl.setText("Resume");
                    btnStop.setEnabled(true);
                    break;
            }
        }

        @Override
        public void onNotAuthen() {
        }

        @Override
        public void onLicenseInvalid() {
        }
    };

//    public void creatStoreState(BaseStoreOrderInfo baseStoreOrderInfo) {
//        JPanel rowWords = new JPanel();
//
//        rowWords.add(DialogUtil.createLabel(baseStoreOrderInfo.acc_no, 80, null));
//        rowWords.add(new JSeparator(), BorderLayout.CENTER);
//        
//        rowWords.add(DialogUtil.createLabel(baseStoreOrderInfo.acc_no, 80, null));
//        rowWords.add(new JSeparator(), BorderLayout.CENTER);
//        
//        controls.add(rowWords);
//    }
    public static JScrollPane displayData(ArrayList<BaseStoreOrderInfo> listTradeMarkItems, int width, int height) {
//        ArrayList<TradeMarkCheckItem> listTradeMarkItems = new ArrayList<>();

        JPanel controls = new JPanel();
//        SpringLayout layout = new SpringLayout();
//        controls.setLayout(layout);
        controls.setLayout(new BoxLayout(controls, BoxLayout.Y_AXIS));

        for (int i = 0, size = listTradeMarkItems.size(); i < size; i++) {

            BaseStoreOrderInfo tradeMarkItem = listTradeMarkItems.get(i);

//            ProcessPanel processPanel = new ProcessPanel();
//            controls.add(processPanel);
//            controls.add(rowWords);
//            controls.add(rowWords);
//            JSeparator line = new JSeparator();
//            line.setSize(width, 1);
//            controls.add(line);
//            System.out.println("" + controls.getPreferredSize().getWidth() + " | " + controls.getPreferredSize().getHeight());
        }

        System.out.println("" + controls.getWidth() + " | " + controls.getHeight());

        JScrollPane sp = new JScrollPane(controls);
//        Dimension d = sp.getPreferredSize();
//        sp.setPreferredSize(new Dimension(d.width + 30, d.height < height ? d.height + 30 : height));
//        Dimension d = sp.getPreferredSize();
        sp.setSize(new Dimension(width, height));
//        sp.add(controls);

        sp.getVerticalScrollBar().setUnitIncrement(16);

//        javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                sp.getVerticalScrollBar().setValue(0);
//            }
//        });
//        jPanel.removeAll();
//        jPanel.add(sp);
        return sp;
    }

    public void saveStore() {
//        String filePath = txtStoreFilePath.getText();
//
//        if (filePath.isEmpty()) {
//            return;
//        }
//        try {
//            ExcelUtils.updateStoreStatus(filePath, storePageInfo, true, totalProduct);
//        } catch (IOException | InvalidFormatException ex) {
//        }
//
//        for (BaseStoreInfo spi : listStorePage) {
//            if (spi.getOrginalStoreLink().equals(storePageInfo.getOrginalStoreLink())) {
//                spi.setState("Done");
//                break;
//            }
//        }
    }

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        btnStartCrawl.setText("Start");
        btnStop.setEnabled(false);
    }//GEN-LAST:event_btnStopActionPerformed

    private void jTableResultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableResultMouseClicked
        // TODO add your handling code here:
        //        System.out.println("" + orderState);
    }//GEN-LAST:event_jTableResultMouseClicked

    private void btnLoadProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadProfileActionPerformed
        // TODO add your handling code here:
        if (txtProfilePath.getText().trim().isEmpty()) {
            DialogUtil.showErrorMessage(topFrame, "", "Vui lòng nhập đường dẫn profile chrome!");
            return;
        }
        
        String path = txtProfilePath.getText().trim();
        
        File file = new File(path);
        if(!file.exists()) return;
        
        try {
            WindowsShortcut windowsShortcut = new WindowsShortcut(file);
            String params = windowsShortcut.getCommandLineArguments();
            String[] parts = params.split(Pattern.quote("="));
            String profileName = parts[1].substring(1, parts[1].length() - 1);
            
            AliexCrawlSvs.getInstance().initDriver(profileName);
//            AliexCrawlSvs.getInstance().goToPage("https://sellercentral.amazon.com/gestalt/managecustomization/index.html?sku=TLT96593_32602048616_3");
//            AmzListingCrawlSvs.getInstance().goToPage("https://sellercentral.amazon.com");
            AliexCrawlSvs.getInstance().goToPage("https://www.aliexpress.com/");
            Configs.isClickedLoadProfile = true;
            
        } catch (Exception ex) {
            Logger.getLogger(ClientTestPanel.class.getName()).log(Level.SEVERE, null, ex);
            DialogUtil.showErrorMessage(topFrame, "", "" + ex.getMessage());
        }
    }//GEN-LAST:event_btnLoadProfileActionPerformed

    private void btnBrowseProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseProfileActionPerformed
        // TODO add your handling code here:
        choosertitle = "Select file:";
        chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(choosertitle);
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        //
        // disable the "All files" option.
        //
        chooser.setAcceptAllFileFilterUsed(false);
        //
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            String path = chooser.getSelectedFile().getPath();
//            Configs.changeProfilePath(path);
//            txtProfilePath.setText(Configs.profilePath);
        } else {
            System.out.println("No Selection ");
        }
    }//GEN-LAST:event_btnBrowseProfileActionPerformed

    private void jTextFieldLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLanguageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLanguageActionPerformed

    private void jButtonSaveCookiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveCookiesActionPerformed
        // TODO add your handling code here:
        String type = jTextFieldLanguage.getText();
        if (type.isEmpty()) {
            type = "us";
        }
        AliexCrawlSvs.getInstance().saveNewCookies(type + ".txt");
        
    }//GEN-LAST:event_jButtonSaveCookiesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String type = jTextFieldLanguage.getText();
        if (type.isEmpty()) {
            type = "us";
        }
        String cookieFile = String.valueOf(CACHE_PATH + type + ".txt");
        Map<String, String> cookies = CookieUtil.getCookiesFromCache(cookieFile);
        AliexCrawlSvs.getInstance().addCookies(cookies);
        AliexCrawlSvs.getInstance().goToPage(txtStoreFilePath.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowseProfile;
    private javax.swing.JButton btnLoadProfile;
    private javax.swing.JButton btnStartCrawl;
    private javax.swing.JButton btnStop;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonSaveCookies;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResult;
    private javax.swing.JTextField jTextFieldLanguage;
    private javax.swing.JLabel lblDownloadState;
    private javax.swing.JPanel statePannel;
    private javax.swing.JTextField txtProfilePath;
    private javax.swing.JTextField txtStoreFilePath;
    // End of variables declaration//GEN-END:variables
}