package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Button;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import ConnectDB.ConnectDB;
import DAO.KhachHang_DAO;
import DAO.NCC_DAO;
import entity.KhachHang;
import entity.NhaCungCap;

public class GUI_KhacHang extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_4;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtUudai;
	private JTable table_KhachHang;
	private JTextField txtDiaChi;
	private JDateChooser dateChooser;
	JTable table;
	DefaultTableModel DataModel;
	private KhachHang_DAO kh;
	
	private DefaultComboBoxModel<String> cboModelTK;
	private JComboBox<String> comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_KhacHang frame = new GUI_KhacHang();
					KhachHang_DAO kh=new KhachHang_DAO();
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
	public GUI_KhacHang() {
		
		ConnectDB.getInstance().connect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Quản lý khách hàng");
		setBounds(100, 100, 1150, 680);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(234, 198, 150));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JPanel pnTimer = new JPanel();
		pnTimer.setBackground(new Color(17, 57, 70));
		pnTimer.setBounds(0, 0, 165, 58);
		contentPane.add(pnTimer);
		
		 JLabel lblNewLabel_1 = new JLabel("");
		 pnTimer.add(lblNewLabel_1);
		 lblNewLabel_1.setForeground(new Color(255, 255, 255));
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		 lblNewLabel_1.setBackground(new Color(17, 57, 70));
		 lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("Quản lý khách hàng");
		lblNewLabel.setForeground(new Color(234, 198, 150));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(429, -10, 382, 68);
		contentPane.add(lblNewLabel);
		
		JButton btnKhachHang = new JButton("Khách hàng");
		btnKhachHang.setVerticalAlignment(SwingConstants.BOTTOM);
		btnKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnKhachHang.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/khachhang_img.png")));
		btnKhachHang.setForeground(new Color(255, 255, 255));
		btnKhachHang.setBackground(new Color(17, 57, 70));
		btnKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnKhachHang.setBounds(0, 59, 165, 58);
		btnKhachHang.setContentAreaFilled(false);
		btnKhachHang.setFocusPainted(false);
		btnKhachHang.setOpaque(true);
		contentPane.add(btnKhachHang);
		
		btnKhachHang.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnKhachHang.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnKhachHang.setBackground(new Color(17, 57, 70));
		    }
		});
		
		
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


	        btnKhachHang.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Show the pop-up menu when the "Khách hàng" button is clicked
	                popupMenu.show(btnKhachHang, 0, btnKhachHang.getHeight());
	            }
	        });

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
		
		JButton btnSach = new JButton("Sách\r\n");
		btnSach.setHorizontalAlignment(SwingConstants.LEFT);
		btnSach.setVerticalAlignment(SwingConstants.TOP);
		btnSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/sach_img.png")));
		btnSach.setForeground(new Color(255, 255, 255));
		btnSach.setBackground(new Color(17, 57, 70));
		btnSach.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSach.setBounds(164, 59, 159, 58);
		btnSach.setContentAreaFilled(false);
		btnSach.setFocusPainted(false);
		btnSach.setOpaque(true);
		contentPane.add(btnSach);
		
		btnSach.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnSach.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnSach.setBackground(new Color(17, 57, 70));
		    }
		});
		
		
	     JPopupMenu popupMenuSach = new JPopupMenu();
	     JMenuItem menuItemThemSach = new JMenuItem("Thêm sách");
	        menuItemThemSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
	        menuItemThemSach.setForeground(new Color(255, 255, 255)); 
	        menuItemThemSach.setBackground(new Color(136, 74, 57)); 
	        menuItemThemSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemThemSach.setPreferredSize(new Dimension(157, 58));
	        menuItemThemSach.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI_Sach gui_Sach = new GUI_Sach();
					gui_Sach.setVisible(true);
		            dispose();

				}
			});
	        popupMenuSach.add(menuItemThemSach);
	        
	        JMenuItem menuItemCapNhatSach = new JMenuItem("Cập nhật sách");
	        menuItemCapNhatSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
	        menuItemCapNhatSach.setForeground(new Color(255, 255, 255)); 
	        menuItemCapNhatSach.setBackground(new Color(136, 74, 57));
	        menuItemCapNhatSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemCapNhatSach.setPreferredSize(new Dimension(157, 58));
	        menuItemCapNhatSach.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUI_Sach gui_Sach = new GUI_Sach();
					gui_Sach.setVisible(true);
		            dispose();

				}
			});
	        popupMenuSach.add(menuItemCapNhatSach);
	        
	        JMenuItem menuItemTimKiemSach = new JMenuItem("Tìm kiếm sách");
	        menuItemTimKiemSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
	        menuItemTimKiemSach.setForeground(new Color(255, 255, 255)); 
	        menuItemTimKiemSach.setBackground(new Color(136, 74, 57)); 
	        menuItemTimKiemSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemTimKiemSach.setPreferredSize(new Dimension(157, 58));
	        menuItemTimKiemSach.addActionListener(new ActionListener() {
	  				public void actionPerformed(ActionEvent e) {
	  					GUI_Sach gui_Sach = new GUI_Sach();
	  					gui_Sach.setVisible(true);
			            dispose();

	  				}
	  			});
	        popupMenuSach.add(menuItemTimKiemSach);
	        
	        JMenuItem menuItemXoaSach = new JMenuItem("Xóa sách");
	        menuItemXoaSach.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/delete_img.png")));
	        menuItemXoaSach.setForeground(new Color(255, 255, 255)); 
	        menuItemXoaSach.setBackground(new Color(136, 74, 57)); 
	        menuItemXoaSach.setFont(new Font("Tahoma", Font.PLAIN, 14)); 
	        menuItemXoaSach.setPreferredSize(new Dimension(157, 58));
	        menuItemXoaSach.addActionListener(new ActionListener() {
	  				public void actionPerformed(ActionEvent e) {
	  					GUI_Sach gui_Sach = new GUI_Sach();
	  					gui_Sach.setVisible(true);
			            dispose();

	  				}
	  			});
	        popupMenuSach.add(menuItemXoaSach);
	        
	        btnSach.addActionListener(new ActionListener() {
	        	  public void actionPerformed(ActionEvent e) {
		                
	        		  popupMenuSach.show(btnSach, 0, btnSach.getHeight());
		            }
		        });
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

	       
	        btnSach.setComponentPopupMenu(popupMenuSach);
	   

		
		
		
		JButton btnHoaDon = new JButton("Hóa đơn");
		btnHoaDon.setHorizontalAlignment(SwingConstants.LEFT);
		btnHoaDon.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/bill_imng.png")));
		btnHoaDon.setForeground(new Color(255, 255, 255));
		btnHoaDon.setBackground(new Color(17, 57, 70));
		btnHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnHoaDon.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHoaDon.setBounds(322, 59, 165, 58);
		btnHoaDon.setContentAreaFilled(false);
		btnHoaDon.setFocusPainted(false);
		btnHoaDon.setOpaque(true);
		contentPane.add(btnHoaDon);
		
		btnHoaDon.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnHoaDon.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnHoaDon.setBackground(new Color(17, 57, 70));
		    }
		});
		
		JPopupMenu popupMenuHoaDon = new JPopupMenu();
		JMenuItem menuItemTaoHoaDon = new JMenuItem("Tạo hóa đơn");
		menuItemTaoHoaDon.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
		menuItemTaoHoaDon.setForeground(new Color(255, 255, 255));
		menuItemTaoHoaDon.setBackground(new Color(136, 74, 57));
		menuItemTaoHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTaoHoaDon.setPreferredSize(new Dimension(163, 58));
		menuItemTaoHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_HoaDon guiHoaDon = new GUI_HoaDon();
				guiHoaDon.setVisible(true);
				dispose();
				
			}
		});
		popupMenuHoaDon.add(menuItemTaoHoaDon);

		
		JMenuItem menuItemXemChiTietHoaDon = new JMenuItem("Xem chi tiết hóa đơn");
		menuItemXemChiTietHoaDon.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/payment_img.png")));
		menuItemXemChiTietHoaDon.setForeground(new Color(255, 255, 255));
		menuItemXemChiTietHoaDon.setBackground(new Color(136, 74, 57));
		menuItemXemChiTietHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemXemChiTietHoaDon.setPreferredSize(new Dimension(163, 58));
		menuItemXemChiTietHoaDon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_QLHD guiqlyHoaDon = new GUI_QLHD();
				guiqlyHoaDon.setVisible(true);
				dispose();
				
			}
		});
		popupMenuHoaDon.add(menuItemXemChiTietHoaDon);



		btnHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		     
		        popupMenuHoaDon.show(btnHoaDon, 0, btnHoaDon.getHeight());
		    }
		});

		menuItemTaoHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		      
		    }
		});

		menuItemXemChiTietHoaDon.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});
		
		JButton btnNhanVIen = new JButton("Nhân viên");
		btnNhanVIen.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhanVIen.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/nhanvien_img.png")));
		btnNhanVIen.setForeground(new Color(255, 255, 255));
		btnNhanVIen.setBackground(new Color(17, 57, 70));
		btnNhanVIen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNhanVIen.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNhanVIen.setBounds(486, 59, 165, 58);
		btnNhanVIen.setContentAreaFilled(false);
		btnNhanVIen.setFocusPainted(false);
		btnNhanVIen.setOpaque(true);
		contentPane.add(btnNhanVIen);
		
		btnNhanVIen.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnNhanVIen.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnNhanVIen.setBackground(new Color(17, 57, 70));
		    }
		});
		
		
		JPopupMenu popupMenuNhanVien = new JPopupMenu();
		JMenuItem menuItemThemNhanVien = new JMenuItem("Thêm nhân viên");
		menuItemThemNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
		menuItemThemNhanVien.setForeground(new Color(255, 255, 255));
		menuItemThemNhanVien.setBackground(new Color(136, 74, 57));
		menuItemThemNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemThemNhanVien.setPreferredSize(new Dimension(163, 58));
		menuItemThemNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhanVien guiNhanVien = new GUI_NhanVien();
				guiNhanVien.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNhanVien.add(menuItemThemNhanVien);

		
		JMenuItem menuItemCapNhatNhanVien = new JMenuItem("Cập nhật nhân viên");
		menuItemCapNhatNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
		menuItemCapNhatNhanVien.setForeground(new Color(255, 255, 255));
		menuItemCapNhatNhanVien.setBackground(new Color(136, 74, 57));
		menuItemCapNhatNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuItemCapNhatNhanVien.setPreferredSize(new Dimension(163, 58));
		menuItemCapNhatNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhanVien guiNhanVien = new GUI_NhanVien();
				guiNhanVien.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNhanVien.add(menuItemCapNhatNhanVien);

		
		JMenuItem menuItemTimKiemNhanVien = new JMenuItem("Tìm nhân viên");
		menuItemTimKiemNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
		menuItemTimKiemNhanVien.setForeground(new Color(255, 255, 255));
		menuItemTimKiemNhanVien.setBackground(new Color(136, 74, 57));
		menuItemTimKiemNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTimKiemNhanVien.setPreferredSize(new Dimension(163, 58));
		menuItemTimKiemNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhanVien guiNhanVien = new GUI_NhanVien();
				guiNhanVien.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNhanVien.add(menuItemTimKiemNhanVien);

		
		JMenuItem menuItemXoaNhanVien = new JMenuItem("Xóa nhân viên");
		menuItemXoaNhanVien.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/delete_img.png")));
		menuItemXoaNhanVien.setForeground(new Color(255, 255, 255));
		menuItemXoaNhanVien.setBackground(new Color(136, 74, 57));
		menuItemXoaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemXoaNhanVien.setPreferredSize(new Dimension(163, 58));
		menuItemXoaNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhanVien guiNhanVien = new GUI_NhanVien();
				guiNhanVien.setVisible(true);
				dispose();
				
			}
		});
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
		btnNhanVIen.setComponentPopupMenu(popupMenuNhanVien);

		
		btnNhanVIen.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        popupMenuNhanVien.show(btnNhanVIen, 0, btnNhanVIen.getHeight());
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
		
		JButton btnNhaCungCap = new JButton("Nhà cung cấp");
		btnNhaCungCap.setHorizontalAlignment(SwingConstants.LEFT);
		btnNhaCungCap.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/ncc_img.png")));
		btnNhaCungCap.setForeground(new Color(255, 255, 255));
		btnNhaCungCap.setBackground(new Color(17, 57, 70));
		btnNhaCungCap.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnNhaCungCap.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {				
			}
		});
		btnNhaCungCap.setBounds(650, 59, 165, 58);
		btnNhaCungCap.setContentAreaFilled(false);
		btnNhaCungCap.setFocusPainted(false);
		btnNhaCungCap.setOpaque(true);
		contentPane.add(btnNhaCungCap);
		
		btnNhaCungCap.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnNhaCungCap.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnNhaCungCap.setBackground(new Color(17, 57, 70));
		    }
		});
		
		
		
		JPopupMenu popupMenuNCC = new JPopupMenu();
		JMenuItem menuItemThemNCC = new JMenuItem("Thêm NCC");
		menuItemThemNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/add_img.png")));
		menuItemThemNCC.setForeground(new Color(255, 255, 255));
		menuItemThemNCC.setBackground(new Color(136, 74, 57));
		menuItemThemNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemThemNCC.setPreferredSize(new Dimension(163, 58));
		menuItemThemNCC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhaCungCap guiNhaCungCap = new GUI_NhaCungCap();
				guiNhaCungCap.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNCC.add(menuItemThemNCC);

		
		JMenuItem menuItemCapNhatNCC = new JMenuItem("Cập nhật NCC");
		menuItemCapNhatNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/updated_img.png")));
		menuItemCapNhatNCC.setForeground(new Color(255, 255, 255));
		menuItemCapNhatNCC.setBackground(new Color(136, 74, 57));
		menuItemCapNhatNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemCapNhatNCC.setPreferredSize(new Dimension(163, 58));
		menuItemCapNhatNCC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhaCungCap guiNhaCungCap = new GUI_NhaCungCap();
				guiNhaCungCap.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNCC.add(menuItemCapNhatNCC);

	
		JMenuItem menuItemTimKiemNCC = new JMenuItem("Tìm NCC");
		menuItemTimKiemNCC.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/loupe_img.png")));
		menuItemTimKiemNCC.setForeground(new Color(255, 255, 255));
		menuItemTimKiemNCC.setBackground(new Color(136, 74, 57));
		menuItemTimKiemNCC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemTimKiemNCC.setPreferredSize(new Dimension(163, 58));
		menuItemTimKiemNCC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_NhaCungCap guiNhaCungCap = new GUI_NhaCungCap();
				guiNhaCungCap.setVisible(true);
				dispose();
				
			}
		});
		popupMenuNCC.add(menuItemTimKiemNCC);


		
		btnNhaCungCap.setComponentPopupMenu(popupMenuNCC);

	
		btnNhaCungCap.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        
		        popupMenuNCC.show(btnNhaCungCap, 0, btnNhaCungCap.getHeight());
		    }
		});

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
		
		JButton btnTroGiup = new JButton("Trợ giúp");
		btnTroGiup.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/help_img.png")));
		btnTroGiup.setHorizontalAlignment(SwingConstants.LEFT);
		btnTroGiup.setForeground(new Color(255, 255, 255));
		btnTroGiup.setBackground(new Color(17, 57, 70));
		btnTroGiup.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTroGiup.setBounds(814, 59, 165, 58);
		btnTroGiup.setContentAreaFilled(false);
		btnTroGiup.setFocusPainted(false);
		btnTroGiup.setOpaque(true);
		contentPane.add(btnTroGiup);
		
		btnTroGiup.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnTroGiup.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnTroGiup.setBackground(new Color(17, 57, 70));
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
		menuItemDoiMatKhau.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/reload_img.png")));
		menuItemDoiMatKhau.setForeground(new Color(255, 255, 255));
		menuItemDoiMatKhau.setBackground(new Color(136, 74, 57));
		menuItemDoiMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuItemDoiMatKhau.setPreferredSize(new Dimension(163, 58));
		menuItemDoiMatKhau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_DMK guiDMK = new GUI_DMK();
				guiDMK.setVisible(true);
				dispose();
				
			}
		});
		popupMenuTrGip.add(menuItemDoiMatKhau);

		
		btnTroGiup.setComponentPopupMenu(popupMenuTrGip);

	
		btnTroGiup.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		       
		        popupMenuTrGip.show(btnTroGiup, 0, btnTroGiup.getHeight());
		    }
		});

		menuItemHuongDan.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		   
		    }
		});

		menuItemDoiMatKhau.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		
		    }
		});
		
		JButton btnThoat = new JButton("Thoát (Alt + 4)");
		btnThoat.setHorizontalAlignment(SwingConstants.LEFT);
		btnThoat.setIcon(new ImageIcon(GUI_TrangChu.class.getResource("/imgs/exit_img.png")));
		btnThoat.setForeground(new Color(255, 255, 255));
		btnThoat.setBackground(new Color(17, 57, 70));
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThoat.setBounds(978, 59, 165, 58);
		btnThoat.setContentAreaFilled(false);
		btnThoat.setFocusPainted(false);
		btnThoat.setOpaque(true);
		contentPane.add(btnThoat);
		
		btnThoat.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnThoat.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnThoat.setBackground(new Color(17, 57, 70));
		    }
		});
		
		btnThoat.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Đóng giao diện hiện tại (GUI_NhanVien)
		        dispose();

		        // Hiển thị lại giao diện GUI_TrangChu
		        GUI_TrangChu guiTrangChu = new GUI_TrangChu();
		        guiTrangChu.setVisible(true);
		    }
		});
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEFT);
		btnDangXuat.setIcon(new ImageIcon(GUI_TrangChu.class.getResource("/imgs/logout_img.png")));
		btnDangXuat.setForeground(new Color(255, 255, 255));
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDangXuat.setBackground(new Color(17, 57, 70));
		btnDangXuat.setBounds(978, 27, 158, 33);
		btnDangXuat.setContentAreaFilled(false);
		btnDangXuat.setFocusPainted(false);
		btnDangXuat.setOpaque(true);
		contentPane.add(btnDangXuat);
		
		btnDangXuat.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	btnDangXuat.setBackground(new Color(195,129,84));
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	btnDangXuat.setBackground(new Color(17, 57, 70));
		    }
		});

		btnDangXuat.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất!", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
		        	GUI_DangNhap lg = new GUI_DangNhap();
		            lg.setVisible(true);
		            dispose();
		        }
		    }
		});
		
		JPanel pnUser = new JPanel();
		pnUser.setBackground(new Color(17, 57, 70));
		pnUser.setBounds(978, 0, 158, 27);
		contentPane.add(pnUser);
		pnUser.setLayout(null);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setIcon(new ImageIcon(GUI_KhacHang.class.getResource("/imgs/user_img.png")));
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setBounds(10, 0, 108, 22);
		pnUser.add(lblUser);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(107, 11, 0, 0);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_1.setBackground(new Color(17, 57, 70));
		pnUser.add(lblNewLabel_1_1);
		Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                lblNewLabel_1.setText("" + sdf.format(new Date()));
            }
        });
        timer.start();
        
        
        //Body 
        
        
        
        
        //Code
		
//		ButtonGroup buttonGroup = new ButtonGroup();
//		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setForeground(new Color(249, 224, 187));
//		comboBox.setBackground(new Color(17, 57, 70));
//		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Tìm kiếm theo", "\t\t\tMã ", "\t\t\tTên"}));
//		comboBox.setBounds(694, 575, 159, 42);
//		contentPane.add(comboBox);
        
		
		
		
		JLabel lblMaKH = new JLabel("Mã KH");
		lblMaKH.setForeground(new Color(234, 198, 150));
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaKH.setBounds(10, 142, 102, 32);
		contentPane.add(lblMaKH);
		
		JLabel lblTenKH = new JLabel("Tên KH");
		lblTenKH.setForeground(new Color(234, 198, 150));
		lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTenKH.setBounds(10, 223, 102, 32);
		contentPane.add(lblTenKH);
		
		
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setForeground(new Color(234, 198, 150));
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgaySinh.setBounds(10, 308, 102, 32);
		contentPane.add(lblNgaySinh);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setForeground(new Color(234, 198, 150));
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDiaChi.setBounds(10, 384, 118, 32);
		contentPane.add(lblDiaChi);
		
//		JLabel lblUudai = new JLabel("Ưu đãi");
//		lblUudai.setForeground(new Color(234, 198, 150));
//		lblUudai.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		lblUudai.setBounds(10, 529, 102, 32);
//		contentPane.add(lblUudai);
		
		JLabel lblSDT = new JLabel("SĐT");
		lblSDT.setForeground(new Color(234, 198, 150));
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSDT.setBounds(10, 463, 118, 32);
		contentPane.add(lblSDT);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(357, 180, 779, 350);
		
		
		String[] headers = "Mã KH; Tên KH;Ngày Sinh; Địa chỉ; SĐT".split(";");
		DataModel = new DefaultTableModel (headers,0);
		
		scrollPane.setViewportView(table = new JTable(DataModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		contentPane.add(scrollPane);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd-MM-yyyy");
		dateChooser.setBounds(148, 308, 149, 32);
		contentPane.add(dateChooser);
		
		
		
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(148, 384, 149, 32);
		contentPane.add(txtDiaChi);
		
		
		
		
		
		
		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMaKH.setBounds(148, 142, 149, 32);
		contentPane.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTenKH.setColumns(10);
		txtTenKH.setBounds(148, 225, 149, 32);
		contentPane.add(txtTenKH);
		
		
//		txtUudai = new JTextField();
//		txtUudai.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		txtUudai.setColumns(10);
//		txtUudai.setBounds(148, 529, 149, 32);
//		contentPane.add(txtUudai);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtSDT.setColumns(10);
		txtSDT.setBounds(148, 463, 149, 32);
		contentPane.add(txtSDT);
		
		
		
		JButton btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setForeground(new Color(249, 224, 187));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLamMoi.setBackground(new Color(17, 57, 70));
		btnLamMoi.setBounds(328, 576, 133, 38);
		contentPane.add(btnLamMoi);
		btnLamMoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Object o = e.getSource();
				if (o.equals(btnLamMoi)) {
					try {
						lamMoi();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				}
				
				
			
		});
		
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCapNhat.setBackground(new Color(17, 57, 70));
		btnCapNhat.setForeground(new Color(249, 224, 187));
		btnCapNhat.setBounds(164, 576, 133, 38);
		contentPane.add(btnCapNhat);
		
		btnCapNhat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
		        if (row < 0) {
		            JOptionPane.showMessageDialog(btnCapNhat, "Vui lòng chọn một khách hàng để cập nhật!");
		            return;
		        }
		        
		        if(checkEmpty()) {
		        	
		        	// TODO Auto-generated method stub
					// Lấy ngày tháng năm từ JCalendar
			        Date ngaySinh = dateChooser.getDate();

			        // Chuyển đổi ngày tháng năm thành kiểu java.sql.Date
			        java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime());
			     
			     // Chuyển đổi giá trị UuDai sang kiểu float
			       // float uuDai = Float.parseFloat(txtUudai.getText());
			        
			        
			        kh.updateKH(new KhachHang(txtMaKH.getText(), txtTenKH.getText(),sqlDate ,txtDiaChi.getText(), txtSDT.getText()));
					
			        updateTable();
			        
			     // Cập nhật bảng
					 table.setValueAt(txtMaKH.getText(), row, 0);
				        table.setValueAt(txtTenKH.getText(), row, 1);
				        table.setValueAt(sqlDate, row, 2);
				        table.setValueAt(txtDiaChi.getText(), row, 3);
				        table.setValueAt( txtSDT.getText(), row, 4);
				        //table.setValueAt( uuDai, row, 5);
				     
				        
			        JOptionPane.showMessageDialog(btnCapNhat, "Chỉnh sửa thành công!");
		        	
		        }
				
				
				
				
		        
			}
			
			
			});
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setForeground(new Color(249, 224, 187));
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThem.setBackground(new Color(17, 57, 70));
		btnThem.setBounds(10, 576, 133, 38);
		contentPane.add(btnThem);
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
		       
		        	// Lấy ngày tháng năm từ JCalendar
			        Date ngaySinh = dateChooser.getDate();

			        // Chuyển đổi ngày tháng năm thành kiểu java.sql.Date
			        java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime());
			        
			        
			     // Chuyển đổi giá trị UuDai sang kiểu float
			        //float uuDai = Float.parseFloat(txtUudai.getText());
			        
			        
			       if(checkEmpty()) {
			    	   kh.addKH(new KhachHang(txtMaKH.getText(),
					            txtTenKH.getText(),
					            //dateChooser.getDate(),
					            sqlDate,
					            txtDiaChi.getText(),
					            txtSDT.getText()
					           ));
					

					        // Cập nhật bảng
					        updateTable();

					        // Hiển thị thông báo thêm thành công
					        JOptionPane.showMessageDialog(btnThem, "Thêm Thành Công!");
			    	   
			       }
			        	
			        	
			        	
			        	
			        
		        	
					
		        
				
				
				
				
			}
		});
		
		
		cboModelTK = new DefaultComboBoxModel<String>();
		comboBox = new JComboBox<String>(cboModelTK);
		comboBox.setForeground(new Color(249, 224, 187));
		comboBox.setBackground(new Color(17, 57, 70));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(719, 575, 135, 42);
		contentPane.add(comboBox);
		updateJComboBox();
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_4.setBounds(853, 575, 142, 42);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/search_img.png")));
		btnSearch.setBackground(new Color(17, 57, 70));
		btnSearch.setBounds(994, 575, 45, 42);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object o = e.getSource();
				if (o.equals(btnSearch) || o.equals(textField_4)) {
					xoaBang();
					if (comboBox.getSelectedIndex() == 0)
						timTheoMa();

					if (comboBox.getSelectedIndex() == 1)
						try {
							if (textField_4.getText().matches("( *)")) {
								updateTable();
								JOptionPane.showMessageDialog(null, "Nhập tên cần tìm!");
								textField_4.setText("");
								textField_4.requestFocus();

							} else {
								timTheoTen();
							}

						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					if (comboBox.getSelectedIndex() == 2)
						try {
							if (textField_4.getText().matches("( *)")) {
								updateTable();
								JOptionPane.showMessageDialog(null, "Nhập số điện thoại cần tìm!");
								textField_4.setText("");
								textField_4.requestFocus();

							} else {
								timTheoSoDT();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					if (o.equals(comboBox)) {
						textField_4.selectAll();
						textField_4.requestFocus();
					}

				}
			}
		});
		
		
		JLabel lbl_main = new JLabel("");
		lbl_main.setIcon(new ImageIcon(GUI_NhaCungCap.class.getResource("/imgs/gui_ncc.png")));
		lbl_main.setBounds(0, 0, 1143, 663);
		contentPane.add(lbl_main);
		
		//1.Add data dô bảng
		kh =new KhachHang_DAO();
		table.setRowHeight(25);
		for(KhachHang n:kh.getAllKH()) {
			
			Object[] rowData= {n.getMaKH(),n.getTenKH(),n.getNgaySinh(),n.getDiaChi(),n.getSdt()};
			DataModel.addRow(rowData);
		}
		
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				assert row >= 0;
				napLopHocVaoTextfields();
			}
		});
		
		
		
		
	
	}
	
	private void napLopHocVaoTextfields() {
		int row = table.getSelectedRow();
		if (row >= 0) {
			txtMaKH.setText((String) table.getValueAt(row, 0));
			txtTenKH.setText((String) table.getValueAt(row, 1));
			 // Lấy ngày tháng từ cột thích hợp của bảng
	        java.util.Date ngaySinh = (java.util.Date) table.getValueAt(row, 2);

	        // Đặt ngày tháng vào dateChooser
	        dateChooser.setDate(ngaySinh);
			txtDiaChi.setText((String) table.getValueAt(row, 3));
			txtSDT.setText((String) table.getValueAt(row, 4));

			// Lấy giá trị uuDai kiểu Float từ bảng
	        //Float uuDai = (Float) table.getValueAt(row, 5);

	        // Chuyển đổi giá trị uuDai thành kiểu String trước khi gán vào trường văn bản
	        //String uuDaiStr = String.valueOf(uuDai);
	       // txtUudai.setText(uuDaiStr);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	private void updateTable() {
		DataModel.setRowCount(0);
		for(KhachHang n:kh.getAllKH()) {
			
				
			Object[] rowData= {n.getMaKH(),n.getTenKH(),n.getNgaySinh(),n.getDiaChi(),n.getSdt()};
				DataModel.addRow(rowData);
				
			
		}
	}
	private void selecttedRow(int row) {
		if(row!=-1) {
			table.setRowSelectionInterval(row, row);
			table.scrollRectToVisible(table.getCellRect(row, row, true));
		}
	}
	
	
	private void updateJComboBox() {
		cboModelTK.addElement("Mã Khách Hàng");
		cboModelTK.addElement("Tên Tên Khách Hàng");
		
	}
	
	

	
	private void xoaBang() {
		for (int j = 0; j < table.getRowCount(); j++) {
			DataModel.removeRow(j);
			j--;
		}
	}
	
	// Kiểm Tra Xác Thực 
			private Boolean checkEmpty() {
				String makh = txtMaKH.getText();
				String tenkh = txtTenKH.getText();
				
				
				
				String diachi = txtDiaChi.getText();
				String sodt = txtSDT.getText();
				
				
				
				Date ngaySinh = dateChooser.getDate();
			    Date currentDate = new Date();
				if (makh.trim().equals("")) {
					return showErrorTx(txtMaKH, "Mã  Khách Hàng không được để trống");

				}else if (!(makh.length() > 0 && makh.matches("^(KH)[0-9]{3}$"))) {
					JOptionPane.showMessageDialog(null, "Không đúng định dạng" + "\nVui lòng nhập theo VD: KH001");
					txtMaKH.selectAll();
					txtMaKH.requestFocus();
					return false;
				} 
				else if (tenkh.trim().equals("")) {
					return showErrorTx(txtTenKH,"Tên Khách Hàng không được để trống");
				}else if(!tenkh.matches("[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\"\r\n"
						+ "				+ \"fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\"\r\n"
						+ "				+ \"UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ ]+")) {
					JOptionPane.showMessageDialog(this, "Nhập sai tên. Tên không chứa số hoặc các ký tự đặc biệt", "Thông báo",
							JOptionPane.ERROR_MESSAGE);
					txtTenKH.selectAll();
					txtTenKH.requestFocus();
					return false;
					

				
				}else if (ngaySinh.after(currentDate)) {
			        JOptionPane.showMessageDialog(this, "Ngày sinh phải nhỏ hơn hoặc bằng ngày hiện tại.", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
			        dateChooser.setDate(null); // Xóa ngày sinh trên JCalendar
			        return false;
			    }
				else if (diachi.trim().equals("")) {
					return showErrorTx(txtDiaChi,"Địa Chỉ không được để trống");
				}else if(!diachi.matches("[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆ\r\n"
								+ "fFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTu\r\n"
								+ "UùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ 0-9,./-]+") || diachi.length() < 0) {
					JOptionPane.showMessageDialog(this, "Địa chỉ không chứa ký tự đặc biệt", "Thông báo",
							JOptionPane.ERROR_MESSAGE);
					txtDiaChi.selectAll();
					txtDiaChi.requestFocus();
					return false;
					
				}
				else if (sodt.trim().equals("")) {
					return showErrorTx(txtDiaChi, "Số điện thoại không được để trống");
				}
				else if(sodt.length() < 0 || !sodt.matches("^0[0-9]{9}")) {
					JOptionPane.showMessageDialog(this, "Số Điện Thoại Nhập Vào Không Hợp Lệ !", "Thông báo",
							JOptionPane.ERROR_MESSAGE);
					txtSDT.selectAll();
					txtSDT.requestFocus();
					return false;
				
				}

				return true;
			}




			private Boolean showErrorTx(JTextField tx,String errorInfo) {
				JOptionPane.showMessageDialog(tx, errorInfo);
				tx.requestFocus();
				return false;
			}
			
			private void timTheoSoDT() throws SQLException {
				table.clearSelection();
				String soDT = textField_4.getText();
				//NhaCungCap ncc = new NhaCungCap();
				KhachHang kh=new KhachHang();
				//NCC_DAO daoNCC = new NCC_DAO();
				KhachHang_DAO daokh=new KhachHang_DAO();
				kh = daokh.getKHTheoSDT(soDT);
				if (kh == null) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy Nhà Cung Cấp! ");
				} else {
					// Chuyển đổi ngày sinh thành một chuỗi để hiển thị
			        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			        String ngaySinhStr = dateFormat.format(kh.getNgaySinh());

					String[] row = {kh.getMaKH(), kh.getTenKH(), ngaySinhStr,kh.getDiaChi(),kh.getSdt() };
					DataModel.addRow(row);
				}
				table.setModel(DataModel);
			}

			private void timTheoTen() throws SQLException {
				table.clearSelection();
				String ten = textField_4.getText();
				//NCC_DAO daoNCC = new NCC_DAO();
				KhachHang_DAO daokh=new KhachHang_DAO();
				List<KhachHang> listkh = daokh.getKHTheoTen(ten);
				if (listkh.size() == 0) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy tên Nhà Cung Cấp theo ten! ");

				} else {
					for (KhachHang kh : listkh) {

						// Chuyển đổi ngày sinh thành một chuỗi để hiển thị
				        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				        String ngaySinhStr = dateFormat.format(kh.getNgaySinh());

						String[] row = {kh.getMaKH(), kh.getTenKH(), ngaySinhStr,kh.getDiaChi(),kh.getSdt() };
						DataModel.addRow(row);
					}

					table.setModel(DataModel);
				}
			}
			
			private void timTheoMa() {
				table.clearSelection();
				String makh = textField_4.getText();
				//NhaCungCap ncc = new NhaCungCap();
				//NCC_DAO daoNCC = new NCC_DAO();
				KhachHang kh=new KhachHang();
				KhachHang_DAO daokh=new KhachHang_DAO();
				kh = daokh.getKHTheoMa(makh);

				if (kh == null) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy Nhà Cung Cấp ");
				} else {

					// Chuyển đổi ngày sinh thành một chuỗi để hiển thị
			        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			        String ngaySinhStr = dateFormat.format(kh.getNgaySinh());

					String[] row = {kh.getMaKH(), kh.getTenKH(), ngaySinhStr,kh.getDiaChi(),kh.getSdt() };
					DataModel.addRow(row);
				}

				table.setModel(DataModel);
			}
			
			
			private void lamMoi() throws SQLException {
				textField_4.setText("");
				comboBox.setSelectedIndex(0);
				xoaBang();
				updateTable();
			}
	
			
}
