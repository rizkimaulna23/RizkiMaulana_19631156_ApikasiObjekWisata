package AplikasiWisata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class HalamanTiket extends javax.swing.JInternalFrame {

    public HalamanTiket() {
        initComponents();
        getIdWisata();
        getIdEvent();
        tampilData();
    }
    
    public final Connection conn = new Koneksi().getConnection();
    Statement st;
    ResultSet rs;
    DefaultTableModel tabMode;
    
    public void getIdWisata(){
        try {
            String sql = "SELECT * FROM tbl_wisata";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                cmbIDWisata.addItem(rs.getString("id_wisata").toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void getIdEvent(){
        try {
            String sql = "SELECT * FROM tbl_event";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()){
                cmbIDEvent.addItem(rs.getString("id_event").toString());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    public void tampilData(){
        Object [] baris = {"NO", "ID Tiket" ,"ID Wisata", "Nama Objek Wisata","ID Event", "Nama Event", "Tanggal Event", "Keterangan","Tanggal Tiket","Jumlah Tiket", "Biaya Tiket"};
        tabMode = new DefaultTableModel(null, baris);
        tableData.setModel(tabMode);
        try {
            String sql = "SELECT tbl_tiket.id_tiket, tbl_wisata.id_wisata, tbl_wisata.nama, tbl_event.*, tbl_tiket.tgl_tiket, tbl_tiket.jml_tiket, tbl_tiket.biaya_tiket FROM tbl_wisata, tbl_event, tbl_tiket WHERE tbl_tiket.id_wisata = tbl_wisata.id_wisata AND tbl_tiket.id_event = tbl_event.id_event";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            int no = 0;
            while (rs.next()){
                no++;
                
                String id_tiket = rs.getString("id_tiket");
                
                String id_wisata = rs.getString("id_wisata");
                String namaWisata = rs.getString("nama");
                
                String id_event = rs.getString("id_event");
                String nama = rs.getString("nama_event");
                String tgl_event = rs.getString("tgl_event");
                String keterangan = rs.getString("keterangan");
                
                String tgl_tiket = rs.getString("tgl_tiket");
                String jml_tiket = rs.getString("jml_tiket");
                String biaya_tiket = rs.getString("biaya_tiket");

                Object [] data = {no,id_tiket,id_wisata,namaWisata, id_event,nama,tgl_event,keterangan, tgl_tiket,jml_tiket,biaya_tiket};
                tabMode.addRow(data);
            }
        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
    
    public void reset(){
        txtID.setText("");
        
        cmbIDWisata.setSelectedItem(null);
        txtNamaObjekWisata.setText("");
        
        cmbIDEvent.setSelectedItem(null);
        txtNamaEvent.setText("");
        txtTanggalEvent.setText("");
        txtKeteranganEvent.setText("");
        
        tanggal.setDate(null);
        txtJumlahTiket.setText("");
        txtBiaya.setText("");
        
        txtID.requestFocus();
        txtID.setEnabled(true);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbIDWisata = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNamaObjekWisata = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbIDEvent = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNamaEvent = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTanggalEvent = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtKeteranganEvent = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtJumlahTiket = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtBiaya = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        tanggal = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableData = new javax.swing.JTable();

        setClosable(true);

        jLabel1.setText("ID Tiket");

        jLabel2.setText("ID Wisata");

        cmbIDWisata.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbIDWisataPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel3.setText("Nama Objek Wisata");

        txtNamaObjekWisata.setEditable(false);

        jLabel4.setText("ID Event");

        cmbIDEvent.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cmbIDEventPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel5.setText("Nama Event");

        txtNamaEvent.setEditable(false);

        jLabel6.setText("Tanggal Event");

        txtTanggalEvent.setEditable(false);

        jLabel7.setText("Keterangan");

        txtKeteranganEvent.setEditable(false);

        jLabel8.setText("Tanggal Input");

        jLabel9.setText("Jumlah Tiket");

        jLabel10.setText("Biaya Tiket");

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnUbah.setText("UBAH");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnReset.setText("RESET");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnCetak.setText("CETAK");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtJumlahTiket)
                            .addComponent(txtBiaya)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCetak))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(txtKeteranganEvent))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                                .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaEvent)
                            .addComponent(cmbIDEvent, 0, 250, Short.MAX_VALUE)
                            .addComponent(txtID)
                            .addComponent(cmbIDWisata, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNamaObjekWisata)
                            .addComponent(txtTanggalEvent))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbIDWisata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNamaObjekWisata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbIDEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNamaEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTanggalEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtKeteranganEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtJumlahTiket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnUbah)
                    .addComponent(btnHapus)
                    .addComponent(btnReset)
                    .addComponent(btnCetak))
                .addContainerGap(133, Short.MAX_VALUE))
        );

        tableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableData);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1039, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbIDWisataPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbIDWisataPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM tbl_wisata WHERE id_wisata = '"+cmbIDWisata.getSelectedItem()+"' ";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()){
                txtNamaObjekWisata.setText(rs.getString("nama"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_cmbIDWisataPopupMenuWillBecomeInvisible

    private void cmbIDEventPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cmbIDEventPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        try {
            String sql = "SELECT * FROM tbl_event WHERE id_event = '"+cmbIDEvent.getSelectedItem()+"' ";
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            if (rs.next()){
                txtNamaEvent.setText(rs.getString("nama_event"));
                txtTanggalEvent.setText(rs.getString("tgl_event"));
                txtKeteranganEvent.setText(rs.getString("keterangan"));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_cmbIDEventPopupMenuWillBecomeInvisible

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        try {
            if (txtID.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Id Wisata Wajib Disi");
                txtID.requestFocus();
            } else if (cmbIDWisata.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null, "ID Wisata Belum Dipilih");
            } else if (cmbIDEvent.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null, "ID Event Belum Dipilih");
            } else if (tanggal.getDate().equals("")){
                JOptionPane.showMessageDialog(null, "Tanggal Wajib Disi");
                tanggal.requestFocus();
            } else if (txtJumlahTiket.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Jumlah Tiket Wajib Disi");
                txtJumlahTiket.requestFocus();
            } else if (txtBiaya.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Biaya Tiket Wajib Disi");
                txtBiaya.requestFocus();
            } else {
                int simpan;
                
                String id_wisata = cmbIDWisata.getSelectedItem().toString();
                String id_event = cmbIDEvent.getSelectedItem().toString();
                
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                String tgl_tiket = String.valueOf(dateformat.format(tanggal.getDate()));

                String sql = "INSERT INTO tbl_tiket VALUES ('"+txtID.getText()+"', '"+id_wisata+"', '"+id_event+"', '"+tgl_tiket+"', '"+txtJumlahTiket.getText()+"', '"+txtBiaya.getText()+"')";
                st = conn.createStatement();
                simpan = st.executeUpdate(sql);

                if (simpan == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                    reset();
                    tampilData();
                }
            }

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        // TODO add your handling code here:
        try {
            if (txtID.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Id Wisata Wajib Disi");
                txtID.requestFocus();
            } else if (cmbIDWisata.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null, "ID Wisata Belum Dipilih");
            } else if (cmbIDEvent.getSelectedItem().equals("")){
                JOptionPane.showMessageDialog(null, "ID Event Belum Dipilih");
            } else if (tanggal.getDate().equals("")){
                JOptionPane.showMessageDialog(null, "Tanggal Wajib Disi");
                tanggal.requestFocus();
            } else if (txtJumlahTiket.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Jumlah Tiket Wajib Disi");
                txtJumlahTiket.requestFocus();
            } else if (txtBiaya.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Biaya Tiket Wajib Disi");
                txtBiaya.requestFocus();
            } else {
                int ubah;
                
                String id_wisata = cmbIDWisata.getSelectedItem().toString();
                String id_event = cmbIDEvent.getSelectedItem().toString();
                
                SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                String tgl_tiket = String.valueOf(dateformat.format(tanggal.getDate()));

                String sql = "UPDATE tbl_tiket SET id_wisata = '"+id_wisata+"', id_event = '"+id_event+"', tgl_tiket = '"+tgl_tiket+"', jml_tiket = '"+txtJumlahTiket.getText()+"', biaya_tiket = '"+txtBiaya.getText()+"' WHERE id_tiket = '"+txtID.getText()+"'";
                st = conn.createStatement();
                ubah = st.executeUpdate(sql);

                if (ubah == 1){
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    reset();
                    tampilData();
                }
            }

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tableDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDataMouseClicked
        // TODO add your handling code here:
        try {
            int baris = tableData.getSelectedRow();
            txtID.setText(tableData.getValueAt(baris, 1).toString()); 
            cmbIDWisata.setSelectedItem(tableData.getValueAt(baris, 2).toString());
            txtNamaObjekWisata.setText(tableData.getValueAt(baris, 3).toString());           
            cmbIDEvent.setSelectedItem(tableData.getValueAt(baris, 4).toString());
            txtNamaEvent.setText(tableData.getValueAt(baris, 5).toString());
            txtTanggalEvent.setText(tableData.getValueAt(baris, 6).toString());
            txtKeteranganEvent.setText(tableData.getValueAt(baris, 7).toString());
            String tgl = tableData.getValueAt(baris, 8).toString();
            Date stanggal = new SimpleDateFormat("yyyy-MM-dd").parse(tgl);
            tanggal.setDate(stanggal);        
            txtJumlahTiket.setText(tableData.getValueAt(baris, 9).toString());
            txtBiaya.setText(tableData.getValueAt(baris, 10).toString());
            txtID.setEnabled(false);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_tableDataMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        try {
            int hapus;

            String sql = "DELETE FROM tbl_tiket WHERE id_tiket = '"+txtID.getText()+"' ";
            st = conn.createStatement();
            hapus = st.executeUpdate(sql);

            if (hapus == 1){
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                reset();
                tampilData();
            }

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        JasperReport reports;

        String path=".\\src\\AplikasiWisata\\LaporanTiket.jasper";
        try {
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, conn);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_btnCetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUbah;
    private javax.swing.JComboBox<String> cmbIDEvent;
    private javax.swing.JComboBox<String> cmbIDWisata;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableData;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JTextField txtBiaya;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtJumlahTiket;
    private javax.swing.JTextField txtKeteranganEvent;
    private javax.swing.JTextField txtNamaEvent;
    private javax.swing.JTextField txtNamaObjekWisata;
    private javax.swing.JTextField txtTanggalEvent;
    // End of variables declaration//GEN-END:variables
}
