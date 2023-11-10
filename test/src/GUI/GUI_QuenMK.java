package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import GUI.GUI_NhaCungCap;
import GUI.GUI_NhanVien;

import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Button;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class GUI_QuenMK extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private Color normalColor;
	private Color pressedColor;
	private JTextField txtNhpMailCa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_QuenMK frame = new GUI_QuenMK();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_QuenMK() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Trang chủ");
		setBounds(100, 100, 1150, 680);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(234, 198, 150));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GIÁ TRỊ THẬT CỦA MỘT CUỐN SÁCH KHÔNG THỂ NẰM HẾT Ở TRANG BÌA");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(234, 198, 150));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 0, 1143, 68);
		contentPane.add(lblNewLabel);
		
		
	       JPopupMenu popupMenu = new JPopupMenu();
	        JMenuItem menuItemThem = new JMenuItem("Thêm khách hàng");
	        menuItemThem.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
	        menuItemThem.setForeground(new Color(255, 255, 255)); // Set text color
	        menuItemThem.setBackground(new Color(136, 74, 57)); // Set background color
	        menuItemThem.setFont(new Font("Tahoma", Font.PLAIN, 14)); // Set font
	        menuItemThem.setPreferredSize(new Dimension(163, 58));
	        popupMenu.add(menuItemThem);
	        
	        JMenuItem menuItemCapNhat = new JMenuItem("Cập nhật khách hàng");
	        menuItemCapNhat.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
	        menuItemCapNhat.setForeground(new Color(255, 255, 255));
	        menuItemCapNhat.setBackground(new Color(136, 74, 57));
	        menuItemCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        menuItemCapNhat.setPreferredSize(new Dimension(163, 58));
	        popupMenu.add(menuItemCapNhat);
	        
	        JMenuItem menuItemTimKiem = new JMenuItem("Tìm khách hàng");
	        menuItemTimKiem.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
	        menuItemTimKiem.setForeground(new Color(255, 255, 255));
	        menuItemTimKiem.setBackground(new Color(136, 74, 57));
	        menuItemTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        menuItemTimKiem.setPreferredSize(new Dimension(163, 58));
	        popupMenu.add(menuItemTimKiem);

	        menuItemThem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Add your logic for "Thêm" here
	            }
	        });

	        menuItemCapNhat.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Add your logic for "Cập nhật" here
	            }
	        });

	        menuItemTimKiem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Add your logic for "tìm kiếm" here
	            }
	        });
		
		
	     JPopupMenu popupMenuSach = new JPopupMenu();
	        JMenuItem menuItemThemSach = new JMenuItem("Thêm sách");
	        menuItemThemSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
	        menuItemThemSach.setForeground(new Color(255, 255, 255)); 
	        menuItemThemSach.setBackground(new Color(136, 74, 57)); 
	        menuItemThemSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemThemSach.setPreferredSize(new Dimension(157, 58));
	        popupMenuSach.add(menuItemThemSach);
	        
	        JMenuItem menuItemCapNhatSach = new JMenuItem("Cập nhật sách");
	        menuItemCapNhatSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
	        menuItemCapNhatSach.setForeground(new Color(255, 255, 255)); 
	        menuItemCapNhatSach.setBackground(new Color(136, 74, 57));
	        menuItemCapNhatSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemCapNhatSach.setPreferredSize(new Dimension(157, 58));
	        popupMenuSach.add(menuItemCapNhatSach);
	        
	        JMenuItem menuItemTimKiemSach = new JMenuItem("Tìm kiếm sách");
	        menuItemTimKiemSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
	        menuItemTimKiemSach.setForeground(new Color(255, 255, 255)); 
	        menuItemTimKiemSach.setBackground(new Color(136, 74, 57)); 
	        menuItemTimKiemSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemTimKiemSach.setPreferredSize(new Dimension(157, 58));
	        popupMenuSach.add(menuItemTimKiemSach);
	        
	        JMenuItem menuItemXoaSach = new JMenuItem("Xóa sách");
	        menuItemXoaSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/delete_img.png")));
	        menuItemXoaSach.setForeground(new Color(255, 255, 255)); 
	        menuItemXoaSach.setBackground(new Color(136, 74, 57)); 
	        menuItemXoaSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemXoaSach.setPreferredSize(new Dimension(157, 58));
	        popupMenuSach.add(menuItemXoaSach);
	        menuItemThemSach.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               
	            }
	        });
	        popupMenuSach.add(menuItemThemSach);

	      
	       
	        menuItemCapNhatSach.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	              
	            }
	        });
	        popupMenuSach.add(menuItemCapNhatSach);

	      
	        
	        menuItemTimKiemSach.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            
	            }
	        });
	        popupMenuSach.add(menuItemTimKiemSach);

	       
	       
	        menuItemXoaSach.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	             
	            }
	        });
	        popupMenuSach.add(menuItemXoaSach);
		
		JPopupMenu popupMenuHoaDon = new JPopupMenu();
		JMenuItem menuItemTaoHoaDon = new JMenuItem("Tạo hóa đơn");
		menuItemTaoHoaDon.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
		menuItemTaoHoaDon.setForeground(new Color(255, 255, 255));
		menuItemTaoHoaDon.setBackground(new Color(136, 74, 57));
		menuItemTaoHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTaoHoaDon.setPreferredSize(new Dimension(163, 58));
		popupMenuHoaDon.add(menuItemTaoHoaDon);

		
		JMenuItem menuItemXemChiTietHoaDon = new JMenuItem("Xem chi tiết hóa đơn");
		menuItemXemChiTietHoaDon.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/payment_img.png")));
		menuItemXemChiTietHoaDon.setForeground(new Color(255, 255, 255));
		menuItemXemChiTietHoaDon.setBackground(new Color(136, 74, 57));
		menuItemXemChiTietHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemXemChiTietHoaDon.setPreferredSize(new Dimension(163, 58));
		popupMenuHoaDon.add(menuItemXemChiTietHoaDon);

		menuItemTaoHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		      
		    }
		});

		menuItemXemChiTietHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});
	
		
		
		JPopupMenu popupMenuNhanVien = new JPopupMenu();
		JMenuItem menuItemThemNhanVien = new JMenuItem("Thêm nhân viên");
		menuItemThemNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
		menuItemThemNhanVien.setForeground(new Color(255, 255, 255));
		menuItemThemNhanVien.setBackground(new Color(136, 74, 57));
		menuItemThemNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemThemNhanVien.setPreferredSize(new Dimension(163, 58));
		popupMenuNhanVien.add(menuItemThemNhanVien);

		
		JMenuItem menuItemCapNhatNhanVien = new JMenuItem("Cập nhật nhân viên");
		menuItemCapNhatNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
		menuItemCapNhatNhanVien.setForeground(new Color(255, 255, 255));
		menuItemCapNhatNhanVien.setBackground(new Color(136, 74, 57));
		menuItemCapNhatNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemCapNhatNhanVien.setPreferredSize(new Dimension(163, 58));
		popupMenuNhanVien.add(menuItemCapNhatNhanVien);

		
		JMenuItem menuItemTimKiemNhanVien = new JMenuItem("Tìm nhân viên");
		menuItemTimKiemNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
		menuItemTimKiemNhanVien.setForeground(new Color(255, 255, 255));
		menuItemTimKiemNhanVien.setBackground(new Color(136, 74, 57));
		menuItemTimKiemNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTimKiemNhanVien.setPreferredSize(new Dimension(163, 58));
		popupMenuNhanVien.add(menuItemTimKiemNhanVien);

		
		JMenuItem menuItemXoaNhanVien = new JMenuItem("Xóa nhân viên");
		menuItemXoaNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/delete_img.png")));
		menuItemXoaNhanVien.setForeground(new Color(255, 255, 255));
		menuItemXoaNhanVien.setBackground(new Color(136, 74, 57));
		menuItemXoaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemXoaNhanVien.setPreferredSize(new Dimension(163, 58));
		popupMenuNhanVien.add(menuItemXoaNhanVien);

	
		JMenuItem menuItemXemNhanVienBiXoa = new JMenuItem("Xem nhân viên bị xóa");
		menuItemXemNhanVienBiXoa.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/erase_img.png")));
		menuItemXemNhanVienBiXoa.setForeground(new Color(255, 255, 255));
		menuItemXemNhanVienBiXoa.setBackground(new Color(136, 74, 57));
		menuItemXemNhanVienBiXoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemXemNhanVienBiXoa.setPreferredSize(new Dimension(163, 58));
		popupMenuNhanVien.add(menuItemXemNhanVienBiXoa);

		menuItemXemNhanVienBiXoa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Tạo một thể hiện của GUI_NhanVien
		        GUI_XemTTNVbixoa guiXemTTNVbixoa = new GUI_XemTTNVbixoa();

		        // Ẩn giao diện hiện tại 
		        setVisible(false);

		        // Hiển thị giao diện mới
		        guiXemTTNVbixoa.setVisible(true);
		    }
		});

		menuItemThemNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		    }
		});

		menuItemCapNhatNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		    }
		});

		menuItemTimKiemNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		 
		    }
		});

		menuItemXoaNhanVien.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    
		    }
		});

		menuItemXemNhanVienBiXoa.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		  
		    }
		});
	
		
		
		JPopupMenu popupMenuNCC = new JPopupMenu();
	
		JMenuItem menuItemThemNCC = new JMenuItem("Thêm NCC");
		menuItemThemNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
		menuItemThemNCC.setForeground(new Color(255, 255, 255));
		menuItemThemNCC.setBackground(new Color(136, 74, 57));
		menuItemThemNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemThemNCC.setPreferredSize(new Dimension(163, 58));
		popupMenuNCC.add(menuItemThemNCC);

		
		JMenuItem menuItemCapNhatNCC = new JMenuItem("Cập nhật NCC");
		menuItemCapNhatNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
		menuItemCapNhatNCC.setForeground(new Color(255, 255, 255));
		menuItemCapNhatNCC.setBackground(new Color(136, 74, 57));
		menuItemCapNhatNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemCapNhatNCC.setPreferredSize(new Dimension(163, 58));
		popupMenuNCC.add(menuItemCapNhatNCC);

	
		JMenuItem menuItemTimKiemNCC = new JMenuItem("Tìm NCC");
		menuItemTimKiemNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
		menuItemTimKiemNCC.setForeground(new Color(255, 255, 255));
		menuItemTimKiemNCC.setBackground(new Color(136, 74, 57));
		menuItemTimKiemNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTimKiemNCC.setPreferredSize(new Dimension(163, 58));
		popupMenuNCC.add(menuItemTimKiemNCC);

		menuItemThemNCC.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});

		menuItemCapNhatNCC.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});

		menuItemTimKiemNCC.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		     
		    }
		});
		
		JPopupMenu popupMenuTrGip = new JPopupMenu();

	
		JMenuItem menuItemHuongDan = new JMenuItem("Hướng dẫn sử dụng");
		menuItemHuongDan.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/manual_img.png")));
		menuItemHuongDan.setForeground(new Color(255, 255, 255));
		menuItemHuongDan.setBackground(new Color(136, 74, 57));
		menuItemHuongDan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemHuongDan.setPreferredSize(new Dimension(163, 58));
		popupMenuTrGip.add(menuItemHuongDan);

		
		JMenuItem menuItemDoiMatKhau = new JMenuItem("Đổi mật khẩu");
		menuItemDoiMatKhau.setIcon(new ImageIcon("/imgs/reload_img.png"));
		menuItemDoiMatKhau.setForeground(new Color(255, 255, 255));
		menuItemDoiMatKhau.setBackground(new Color(136, 74, 57));
		menuItemDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemDoiMatKhau.setPreferredSize(new Dimension(163, 58));
		popupMenuTrGip.add(menuItemDoiMatKhau);

		menuItemHuongDan.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});

		menuItemDoiMatKhau.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		
		    }
		});

		
	
		
		JLabel lblNewLabel_3 = new JLabel("QUÊN MẬT KHẨU");
		lblNewLabel_3.setForeground(new Color(255, 194, 111));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBackground(new Color(255, 194, 111));
		lblNewLabel_3.setBounds(324, 95, 520, 100);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Một link để thay đổi mật khẩu sẽ được gửi vào email của bạn.");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(new Color(255, 194, 111));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3_1.setBackground(new Color(255, 194, 111));
		lblNewLabel_3_1.setBounds(324, 205, 520, 49);
		contentPane.add(lblNewLabel_3_1);
		
		txtNhpMailCa = new JTextField();
		txtNhpMailCa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNhpMailCa.setForeground(new Color(0, 0, 0));
		txtNhpMailCa.setBackground(new Color(255, 255, 255));
		txtNhpMailCa.setText("Nhập mail vào đây");
		txtNhpMailCa.setColumns(10);
		txtNhpMailCa.setBounds(334, 252, 495, 32);
		contentPane.add(txtNhpMailCa);
		
		JButton btnresetmk = new JButton("Reset lại mật khẩu");
		btnresetmk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnresetmk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnresetmk.setBounds(334, 294, 495, 54);
		contentPane.add(btnresetmk);
		
		JButton btnTrlai = new JButton("Trở lại đăng nhập");
		btnTrlai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTrlai.setBounds(409, 442, 349, 54);
		btnTrlai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_DangNhap gui_DangNhap = new GUI_DangNhap();
				gui_DangNhap.setVisible(true);
				dispose();
				
			}
		});
		contentPane.add(btnTrlai);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setIcon(new ImageIcon(GUI_QuenMK.class.getResource("/imgs/box1.jpg")));
		lblNewLabel_2.setBounds(324, 95, 520, 493);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("l");
		lblNewLabel_4.setBackground(new Color(204, 0, 153));
		lblNewLabel_4.setIcon(new ImageIcon(GUI_QuenMK.class.getResource("/imgs/main2_img.jpg")));
		lblNewLabel_4.setBounds(0, 0, 1143, 663);
		contentPane.add(lblNewLabel_4);
		
	
	}
}
